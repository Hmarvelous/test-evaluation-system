package online.shixun.project.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import online.shixun.project.dto.TopicDto;

/**
 * 题目服务接口类
 * @ClassName: TopicService.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月21日 下午3:55:02
 */
public interface TopicService {

	/**
	 * 根据试卷ID查询试卷的全部试题
	 * @param paperId 试卷ID
	 * @return 试题答案
	 */
	List<TopicDto> getTopicsByPaperId(Long paperId);
	
	/**
	 * 根据试卷ID查询试题数量
	 * @param paperId 试卷ID
	 * @return 试题数量
	 */
	long getTopicCountByPaperId(Long paperId);
	
	/**
	 * 根据试卷ID与题目ID查询题目信息
	 * @param paperId 试卷ID
	 * @param page 页号(题号)
	 * @param size 每页多少题目
	 * @return 分页对象
	 */
	JSONObject getTopicByPaperIdAndTopicId(Long paperId, Integer page, Integer size);
	
	/**
	 * 效验答案
	 * @param paperId 试卷ID
	 * @param answers 答案集合
	 * @return 分数
	 */
	List<Boolean> validationAnswer(Long paperId, List<String> answers);
}
