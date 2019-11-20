package online.shixun.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import online.shixun.project.dto.UserDto;
import online.shixun.project.mapper.UserMapper;
import online.shixun.project.service.UserService;

/**
 * 用户服务接口实现类
 * @ClassName: UserServiceImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月23日 下午4:54:35
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 通过用户名查询用户信息
	 */
	@Override
	public UserDto getUserByUsername(String username) {
		return userMapper.selectUserByUsername(username);
	}

	/**
	 * 登录
	 */
	@Override
	public JSONObject login(UserDto user) {
		JSONObject json = new JSONObject();
		// 判断用户名或密码是否完整
		if (user == null || (user != null && user.getUsername().length() == 0) || (user != null && user.getPassword().length() == 0)) {
			json.put("result", "请输入用户名或密码");
			return json;
		}
		// 通过用户名查询用户信息
		UserDto u = getUserByUsername(user.getUsername());
		
		if (u == null) {
			json.put("result", "该用户不存在");
			return json;
		}
		
		if (!u.getPassword().equals(user.getPassword())) {
			json.put("result", "密码错误");
			return json;
		}
		
		json.put("result", "success");
		return json;
	}

}
