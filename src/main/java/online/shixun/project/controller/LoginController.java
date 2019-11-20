package online.shixun.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import online.shixun.project.dto.UserDto;
import online.shixun.project.service.UserService;

/**
 * 登录控制器
 * @ClassName: LoginController.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月23日 下午4:43:51
 */
@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private UserService userService;
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "login";
	}
	
	/**
	 * 处理登录逻辑
	 * @return
	 */
	@RequestMapping("/doLogin")
	@ResponseBody
	public JSONObject doLogin(UserDto user, HttpSession session) {
		JSONObject json = userService.login(user);
		if (json.getString("result").equals("success")) {
			// 登录成功
			session.setAttribute("user", user.getUsername());
		}
		return json;
	}

	
	/**
	 * 用户注销逻辑
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// 使Session失效
		session.invalidate();
		return "redirect:/";
	}
}
