package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.text.*;
import org.springframework.test.context.ContextConfiguration;

import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.*;
import com.databasegroup.dao.*;
import com.databasegroup.service.*;
import com.databasegroup.service.impl.*;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testDao")
public class TestDaoController {
	@Autowired
	private IAdminService adminService;
	@RequestMapping(value="/h",method=GET)
	public String home(Model model) {
		
		Admin admin = adminService.getByName("root");
		model.addAttribute("message", admin.getDistrict());
		//model.addAttribute("message", "555");
		return "/fortest/hello";
	}
}