package com.databasegroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method=GET)
	public String home(Model model) {
		model.addAttribute("message", "Hello World!");
		return "/hello";
	}
}