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
			@RequestParam String repassword) {
		return "register";
	}
}
