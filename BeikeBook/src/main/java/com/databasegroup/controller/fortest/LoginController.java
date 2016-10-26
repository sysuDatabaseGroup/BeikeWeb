package com.databasegroup.controller.fortest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method=GET)
	public String login() {
		return "/fortest/login";
	}
	
	@RequestMapping(method=POST)
	public String afterLogin(Model model) {
		model.addAttribute("message", "login successfully");
		return "/fortest/hello";
	}
}
