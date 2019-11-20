package online.shixun.project.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 成绩单实体类
 * @ClassName: TranscriptDto.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月23日 下午7:18:16
 */
public class TranscriptDto {

	/**
	 * 成绩单ID
	 */
	private Long id;
	
	/**
	 * 试卷
	 */
	private PaperDto paper;
	
	/**
	 * 用户
	 */
	private UserDto user;
	
	/**
	 * 答案数组(用英文逗号隔开)
	 */
	private String answers;
	
	/**
	 * 考核分数
	 */
	private Double fraction;

	/**
	 * 交卷时间
	 */
	private Date date;

	/**
	 * 是否有效
	 */
	private Boolean dataFlag;
	
	
	
	public TranscriptDto() { }

	public TranscriptDto(PaperDto paper, UserDto user, String answers, Double fraction, Date date) {
		this.paper = paper;
		this.user = user;
		this.answers = answers;
		this.fraction = fraction;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaperDto getPaper() {
		return paper;
	}

	public void setPaper(PaperDto paper) {
		this.paper = paper;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public Double getFraction() {
		return fraction;
	}

	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}

	public Date getDate() {
		return date;
	}
	
	public String getDateString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getDataFlag() {
		return dataFlag;
	}

	public void setDataFlag(Boolean dataFlag) {
		this.dataFlag = dataFlag;
	}

	@Override
	public String toString() {
		return "TranscriptDto [id=" + id + ", paper=" + paper + ", user=" + user + ", answers=" + answers
				+ ", fraction=" + fraction + ", date=" + date + ", dataFlag=" + dataFlag + "]";
	}

}
