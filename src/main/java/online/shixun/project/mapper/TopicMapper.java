package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import online.shixun.project.dto.TopicDto;

/**
 * @ClassName: TopicPMapper.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月21日 下午3:35:58
 */
@Mapper
public interface TopicMapper {

	/**
	 * 根据试卷ID查询试卷的全部试题
	 * @param paperId 试卷ID
	 * @return 试题答案
	 */
	List<TopicDto> selectTopicsByPaperId(@Param("paperId") Long paperId);
	
	/**
	 * 根据试卷ID查询试题数量
	 * @param paperId 试卷ID
	 * @return 试题数量
	 */
	long selectTopicCountByPaperId(@Param("paperId") Long paperId);
	
	/**
	 * 根据试卷ID与题目ID查询题目信息
	 * @param paperId 试卷ID
	 * @return 题目对象
	 */
	List<TopicDto> selectTopicByPaperIdAndTopicId(@Param("paperId") Long paperId,
												  @Param("start") Integer start,
												  @Param("size") Integer size);
}
