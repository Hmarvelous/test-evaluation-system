package online.shixun.project.controller;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import online.shixun.project.dto.PaperDto;
import online.shixun.project.dto.TranscriptDto;
import online.shixun.project.dto.UserDto;
import online.shixun.project.service.PaperService;
import online.shixun.project.service.TopicService;
import online.shixun.project.service.TranscriptService;
import online.shixun.project.service.UserService;

/**
 * @ClassName: ExamController.java
 * @Description: 考试控制器类
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月21日 下午2:50:32
 */
@Controller
@RequestMapping("/")
public class ExamController {

	@Autowired
	private PaperService paperService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private TranscriptService transcriptService;
	@Autowired
	private UserService userService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model, HttpSession session) {
		// 获取当前登录用户
		String username = (String) session.getAttribute("user");
		if (username == null) {
			// 未登录
			return "redirect:/";
		}
		model.addAttribute("username", username);
		return "index";
	}
	
	/**
	 * 答题页面
	 * @return
	 */
	@RequestMapping("/answer")
	public String answer(@RequestParam("id") Long id, Model model, HttpSession session) {
		// 获取当前登录用户
		String username = (String) session.getAttribute("user");
		if (username == null) {
			// 未登录
			return "redirect:/";
		}
		// 根据试卷ID查询试卷信息
		model.addAttribute("paper", paperService.getPaperById(id));
		// 获取该试卷题目集合
		model.addAttribute("topics", topicService.getTopicsByPaperId(id));
		return "answer";
	}
	
	/**
	 * 获取全部试卷
	 * @return
	 */
	@RequestMapping("/papers")
	@ResponseBody
	public JSONArray papers() {
		return (JSONArray) JSONArray.toJSON(paperService.getAllPapers());
	}
	
	/**
	 * 获取题目
	 * @return
	 */
	@RequestMapping("/topic")
	@ResponseBody
	public JSONObject topic(@RequestParam("paperId") Long paperId,
							@RequestParam("page") Integer page,
							HttpSession session) {
		if (session.getAttribute("paperId") != null && !((Long)session.getAttribute("paperId")).equals(paperId)) {
			session.setAttribute("Answers", null);
			session.setAttribute("topicNumber", 1);
		}
		// 保存试卷ID到Session里面
		session.setAttribute("paperId", paperId);
		return topicService.getTopicByPaperIdAndTopicId(paperId, page, 1);
	}
	
	
	/**
	 * 交卷
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/assignment")
	public String assignment(@RequestParam("id") Long paperId, Model model, HttpSession session) {
		// 获取当前登录用户
		String username = (String) session.getAttribute("user");
		if (username == null) {
			// 未登录
			return "redirect:/";
		}
		List<String> answerList = (List<String>) session.getAttribute("Answers");
		if (answerList == null) {
			session.setAttribute("Answers", null);
			session.setAttribute("paperId", null);
			session.setAttribute("topicNumber", null);
			return "redirect:/index";
		}
		List<Boolean> correctness = topicService.validationAnswer(paperId, answerList);
		model.addAttribute("correctness", correctness);
		model.addAttribute("topics", topicService.getTopicsByPaperId(paperId));
		int count = 0;
		int correctCount = 0;
		for (Boolean b : correctness) {
			if (b != null) {
				count++;
			}
			if (b != null && b) {
				correctCount++;
			}
		}
		model.addAttribute("count", count);
		model.addAttribute("correctCount", correctCount);
		model.addAttribute("fraction", new DecimalFormat("#0.00").format((correctCount / (double)correctness.size()) * 100));
		
		// 保存成绩单
		PaperDto paper = new PaperDto();
		paper.setId(paperId);
		String answers = "";
		for (String s : answerList) {
			answers += s + ',';
		}
		answers = answers.substring(0, answers.length() - 1);
		UserDto user = userService.getUserByUsername(username);
		TranscriptDto transcript = new TranscriptDto(paper, user, answers, (correctCount / (double)correctness.size()) * 100, new Date());
		transcriptService.addTranscript(transcript);
		
		session.setAttribute("Answers", null);
		session.setAttribute("paperId", null);
		session.setAttribute("topicNumber", null);
		
		return "result";
	}
	
	
	/**
	 * 保存答案到Session
	 * @return
	 */
	@RequestMapping("/saveAnswer")
	@ResponseBody
	public JSONObject saveAnswer(@RequestParam("answers") String answers, HttpSession session) {
		JSONObject json = new JSONObject();
		// 解析答案
		List<String> answerList = Arrays.asList(answers.split(","));
		// 保存答案
		session.setAttribute("Answers", answerList);
		json.put("code", "success");
		return json;
	}
	
	
	
	/**
	 * 从Session中获取保存的答案
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getAnswer")
	@ResponseBody
	public List<String> getAnswer(HttpSession session) {
		return (List<String>) session.getAttribute("Answers");
	}
	
	/**
	 * 获取正在作答的试卷ID
	 * @return
	 */
	@RequestMapping("/getPaper")
	@ResponseBody
	public Long getPaper(HttpSession session) {
		return (Long) session.getAttribute("paperId");
	}
	
	
	/**
	 * 保存正在作答的题号
	 * @return
	 */
	@RequestMapping("/saveTopicNumber")
	@ResponseBody
	public JSONObject saveTopicNumber(@RequestParam("topicNumber") Integer topicNumber ,HttpSession session) {
		JSONObject json = new JSONObject();
		session.setAttribute("topicNumber", topicNumber);
		json.put("code", "success");
		return json;
	}
	
	/**
	 * 获取正在作答的题号	
	 * @return
	 */
	@RequestMapping("/getTopicNumber")
	@ResponseBody
	public Integer getTopicNumber(HttpSession session) {
		return (Integer) session.getAttribute("topicNumber");
	}
	
}
