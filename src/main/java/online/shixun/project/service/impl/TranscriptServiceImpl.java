package online.shixun.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import online.shixun.project.dto.TranscriptDto;
import online.shixun.project.mapper.TranscriptMapper;
import online.shixun.project.service.TranscriptService;

/**
 * 成绩单服务接口实现类
 * @ClassName: TranscriptServiceImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月23日 下午7:26:05
 */
@Service
public class TranscriptServiceImpl implements TranscriptService {

	@Autowired
	private TranscriptMapper transcriptMapper;
	
	/**
	 * 添加成绩单
	 */
	@Override
	public boolean addTranscript(TranscriptDto transcript) {
		return transcriptMapper.insertTranscript(transcript) == 1;
	}

	/**
	 * 根据用户名获取全部成绩单
	 */
	@Override
	public List<TranscriptDto> getAllTranscriptByUsername(String username) {
		return transcriptMapper.selectAllTranscriptByUsername(username);
	}

	/**
	 * 获取指定用户成绩单分页数据
	 */
	@Override
	public PageInfo<TranscriptDto> getTranscriptByPage(String username, Integer page, Integer size) {
		PageHelper.startPage(page, size);
		List<TranscriptDto> transcripts = getAllTranscriptByUsername(username);
		PageInfo<TranscriptDto> pageInfo = new PageInfo<TranscriptDto>(transcripts);
		return pageInfo;
	}

	/**
	 * 根据成绩单ID删除成绩单
	 */
	@Override
	public boolean deleteTranscriptById(Long id) {
		return transcriptMapper.deleteTranscriptById(id) == 1;
	}

}
