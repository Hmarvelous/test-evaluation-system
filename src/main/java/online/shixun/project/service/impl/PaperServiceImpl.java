package online.shixun.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.dto.PaperDto;
import online.shixun.project.mapper.PaperMapper;
import online.shixun.project.service.PaperService;

/**
 * 试卷服务接口实现类
 * @ClassName: PaperServiceImpl.java
 * @Description: 实现服务接口类
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月21日 下午3:04:25
 */
@Service
public class PaperServiceImpl implements PaperService{

	@Autowired
	private PaperMapper paperMapper;
	
	/**
	 * 获取全部试卷
	 */
	@Override
	public List<PaperDto> getAllPapers() {
		return paperMapper.selectAllPapers();
	}

	/**
	 * 根据试卷ID查询试卷信息
	 */
	@Override
	public PaperDto getPaperById(Long id) {
		return paperMapper.selectPaperById(id);
	}

	
}
