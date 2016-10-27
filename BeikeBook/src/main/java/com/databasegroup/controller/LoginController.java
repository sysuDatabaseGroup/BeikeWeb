package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.BookCategory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	@RequestMapping(value="/login",method=GET)
	public String login1() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=POST)
	public String login2(
			HttpServletRequest request,
			@RequestParam String username,
			@RequestParam String password) {
		if (username.equals("admin") && password.equals("admin")) {
			//request.getSession().setAttribute("loginReply", "用户名错误, 请重新登录");
			request.getSession().setAttribute("username", "admin");
			request.getSession().setAttribute("message", "登录成功！");
			return "/fortest/showMessage";
		}
		return "login";
	}
}
