package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.BookCategory;
import com.databasegroup.model.User;
import com.databasegroup.service.IUserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegisterController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value="/register",method=GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="/register",method=POST)
	public String registered(
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String repassword,
			@RequestParam String dorm,
			Model model) {
		if (password == null || password.length() == 0 || 
				(password.compareTo(repassword) != 0)) {
			model.addAttribute("message", "两次密码不一致！");
		} else if (username == null || username.length() == 0 ||
				userService.getUserByUserNum(username) != null) {
			model.addAttribute("message", "该用户名已存在");
		} else {
			User user = new User();
			user.setWxName(username);
			user.setUserNum(username);
			user.setPassword(password);
			user.setSchoolId(1); // 默认中大
			user.setDorm(dorm);
			user.setCityId(1); // 广州
			userService.insert(user);
			model.addAttribute("message", "注册成功！");
			return "status_register";
		}
		return "register";
	}
}
