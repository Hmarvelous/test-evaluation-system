package online.shixun.project.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import online.shixun.project.dto.TranscriptDto;

/**
 * 成绩单服务接口类
 * @ClassName: TranscriptService.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月23日 下午7:25:44
 */
public interface TranscriptService {

	/**
	 * 添加成绩单
	 * @param transcript 成绩单对象
	 * @return 添加是否成功
	 */
	boolean addTranscript(TranscriptDto transcript);
	
	/**
	 * 根据用户名获取全部成绩单
	 * @param username 用户名
	 * @return 成绩单集合
	 */
	List<TranscriptDto> getAllTranscriptByUsername(String username);
	
	/**
	 * 获取指定用户成绩单分页数据
	 * @param username 用户名
	 * @param page 获取的页码
	 * @param size 每页的数据大小
	 * @return 分页对象
	 */
	PageInfo<TranscriptDto> getTranscriptByPage(String username, Integer page, Integer size);
	
	/**
	 * 根据成绩单ID删除成绩单
	 * @param id 成绩单ID
	 * @return 删除是否成功
	 */
	boolean deleteTranscriptById(Long id);
	
}
