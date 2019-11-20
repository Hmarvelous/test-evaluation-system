package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import online.shixun.project.dto.TranscriptDto;

/**
 * 
 * @ClassName: TranscriptMapper.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月23日 下午7:19:52
 */
public interface TranscriptMapper {

	/**
	 * 添加成绩单
	 * @param transcript 成绩单对象
	 * @return 返回0为添加失败  返回1为添加成功
	 */
	Integer insertTranscript(@Param("transcript") TranscriptDto transcript);
	
	/**
	 * 根据用户名获取全部成绩单
	 * @param username 用户名
	 * @return 成绩单集合
	 */
	List<TranscriptDto> selectAllTranscriptByUsername(@Param("username") String username);
	
	/**
	 * 根据成绩单ID删除成绩单
	 * @param id 成绩单ID
	 * @return 返回0为删除失败  返回1为删除成功
	 */
	Integer deleteTranscriptById(@Param("id") Long id);
}
