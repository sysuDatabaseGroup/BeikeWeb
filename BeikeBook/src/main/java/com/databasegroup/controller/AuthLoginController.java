package com.databasegroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/authLogin")
public class AuthLoginController {
	
	@RequestMapping(method=GET)
	public String login() {
		return "/fortest/authLogin";
	}
}
