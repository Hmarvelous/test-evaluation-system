package online.shixun.project.dto;

/**
 * @ClassName: PaperDto.java
 * @Description: 试卷实体类
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月21日 下午2:45:03
 */
public class PaperDto {
	
	/**
	 * 试卷ID
	 */
	private Long id;
	
	/**
	 * 试卷名称
	 */
	private String name;
	
	/**
	 * 试卷是否有效
	 */
	private Boolean dataFlag;

	/**
	 * 题目数量
	 */
	private Integer count;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDataFlag() {
		return dataFlag;
	}

	public void setDataFlag(Boolean dataFlag) {
		this.dataFlag = dataFlag;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "PaperDto [id=" + id + ", name=" + name + ", dataFlag=" + dataFlag + ", count=" + count + "]";
	}

}
