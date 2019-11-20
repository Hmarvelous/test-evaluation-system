package online.shixun.project.dto;

/**
 * 用户实体类
 * @ClassName: UserDto.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月23日 下午4:45:59
 */
public class UserDto {

	/**
	 * 用户ID
	 */
	private Long id;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 账户是否有效
	 */
	private Boolean dataFlag;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getDataFlag() {
		return dataFlag;
	}

	public void setDataFlag(Boolean dataFlag) {
		this.dataFlag = dataFlag;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", password=" + password + ", dataFlag=" + dataFlag
				+ "]";
	}
	
}
