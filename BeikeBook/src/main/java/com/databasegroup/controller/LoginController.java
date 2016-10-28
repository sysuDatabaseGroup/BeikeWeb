package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.BookCategory;
import com.databasegroup.service.IUserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/login",method=GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=POST)
	public String loginAuth(
			HttpServletRequest request,
			@RequestParam String username,
			@RequestParam String password,
			Model model) {
		if (userService.authUser(username, password)) {
			request.getSession()
					.setAttribute("user", 
					userService.getUserByUserNum(username));
			return "redirect:/";
		} else {
			model.addAttribute("message", "账号密码错误！");
			return "/login";
		}
	}
	
	@RequestMapping(value="/logout",method=GET)
	public String logout(
			HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}
