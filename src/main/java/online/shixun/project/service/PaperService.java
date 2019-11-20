package online.shixun.project.service;

import java.util.List;

import online.shixun.project.dto.PaperDto;

/**
 * 试卷服务接口类
 * @ClassName: PaperService.java
 * @Description: 试卷的一些方法
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月21日 下午3:03:32
 */
public interface PaperService {

	/**
	 * 获取全部试卷
	 * @return 试卷对象集合
	 */
	List<PaperDto> getAllPapers();
	
	/**
	 * 根据试卷ID查询试卷信息
	 * @param id 试卷ID
	 * @return 试卷对象
	 */
	PaperDto getPaperById(Long id);
	
}
