package online.shixun.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import online.shixun.project.dto.TopicDto;
import online.shixun.project.mapper.TopicMapper;
import online.shixun.project.pojo.PageInfo;
import online.shixun.project.service.TopicService;

/**
 * 题目服务接口实现类
 * @ClassName: TopicServiceImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月21日 下午3:55:42
 */
@Service
public class TopicServiceImpl implements TopicService{

	@Autowired
	private TopicMapper topicMapper;
	
	/**
	 * 根据试卷ID查询试卷的全部试题
	 */
	@Override
	public List<TopicDto> getTopicsByPaperId(Long paperId) {
		return topicMapper.selectTopicsByPaperId(paperId);
	}

	/**
	 * 根据试卷ID查询试卷的全部试题
	 */
	@Override
	public long getTopicCountByPaperId(Long paperId) {
		return topicMapper.selectTopicCountByPaperId(paperId);
	}
	
	/**
	 * 根据试卷ID与题目ID查询题目信息
	 */
	@Override
	public JSONObject getTopicByPaperIdAndTopicId(Long paperId, Integer page, Integer size) {
		
		long total = getTopicCountByPaperId(paperId);
		List<TopicDto> topics = topicMapper.selectTopicByPaperIdAndTopicId(paperId, (page-1)*size, size);
		List<JSONObject> jsons = new ArrayList<JSONObject>();
		for (TopicDto topic : topics) {
			jsons.add(topic.getNotAnswer());
		}
		PageInfo<JSONObject> pageInfo = new PageInfo<JSONObject>(page, size, total, jsons, 11);
		return (JSONObject) JSONObject.toJSON(pageInfo);
	}

	/**
	 * 效验答案
	 */
	@Override
	public List<Boolean> validationAnswer(Long paperId, List<String> answers) {
		List<Boolean> correctness = new ArrayList<Boolean>();
		List<TopicDto> topics = topicMapper.selectTopicsByPaperId(paperId);
		for (int i=0; i<topics.size(); i++) {
			JSONArray jsonArray = topics.get(i).getAnswerJSONArray();
			String correctAnswer = null;
			for (Object o : jsonArray) {
				JSONObject jo = (JSONObject) o;
				if (jo.getBooleanValue("correct")) {
					correctAnswer = jo.getString("number");
				}
			}
			if (answers.get(i).equals(correctAnswer)) {
				correctness.add(i, true);
			} else {
				if (answers.get(i).equals("undefined") || answers.get(i).equals("no-answer")) {
					correctness.add(i, null);
				} else {					
					correctness.add(i, false);
				}
			}
		}
		return correctness;
	}

}
