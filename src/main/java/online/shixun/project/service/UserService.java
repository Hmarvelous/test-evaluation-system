package online.shixun.project.service;

import com.alibaba.fastjson.JSONObject;

import online.shixun.project.dto.UserDto;

/**
 * 用户服务接口类
 * @ClassName: UserService.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月23日 下午4:54:06
 */
public interface UserService {

	/**
	 * 通过用户名查询用户信息
	 * @param username 用户名
	 * @return 用户对象
	 */
	UserDto getUserByUsername(String username);
	
	/**
	 * 登录
	 * @param user 用户对象
	 * @return 返回JSON登录结果
	 */
	JSONObject login(UserDto user);
}
