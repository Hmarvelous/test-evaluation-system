package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import online.shixun.project.dto.PaperDto;

/**
 * @ClassName: PaperMapper.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月21日 下午3:00:13
 */
@Mapper
public interface PaperMapper {

	/**
	 * 获取全部试卷
	 * @return 试卷对象集合
	 */
	List<PaperDto> selectAllPapers();
	
	/**
	 * 根据试卷ID查询试卷信息
	 * @param id 试卷ID
	 * @return 试卷对象
	 */
	PaperDto selectPaperById(@Param("id") Long id);
}
