package online.shixun.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import online.shixun.project.service.TranscriptService;

/**
 * 成绩单控制器
 * @ClassName: TranscriptController.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月23日 下午8:50:51
 */
@Controller
@RequestMapping("/transcript")
public class TranscriptController {

	@Autowired
	private TranscriptService transcriptService;
	
	/**
	 * 成绩单页面
	 * @return
	 */
	@RequestMapping("")
	public String index(@RequestParam(value = "page", defaultValue = "1") Integer page,
						@RequestParam(value = "size", defaultValue = "20") Integer size,
						Model model,
						HttpSession session) {
		// 获取当前登录用户
		String username = (String) session.getAttribute("user");
		if (username == null) {
			// 未登录
			return "redirect:/";
		}
		
		model.addAttribute("transcriptPage", transcriptService.getTranscriptByPage(username, page, size));
		
		return "transcript";
	}
	
	
	/**
	 * 删除成绩单
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public JSONObject delete(@RequestParam("id") Long id) {
		JSONObject json = new JSONObject();
		if (transcriptService.deleteTranscriptById(id)) {
			json.put("result", "success");
			return json;
		}
		json.put("result", "fail");
		return json;
	}
}
