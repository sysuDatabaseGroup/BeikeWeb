package com.databasegroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import com.databasegroup.model.City;
import com.databasegroup.model.School;
import com.databasegroup.model.User;
import com.databasegroup.service.ICityService;
import com.databasegroup.service.ISchoolService;
import com.databasegroup.service.IUserService;

@Controller
public class UserInformationController {

	@Resource
	private ICityService cityService;

	@Resource
	private ISchoolService schoolService;

	@Resource
	private IUserService userService;

	@RequestMapping(value = "/user_information", method = GET)
	public String userInformation(Model model, HttpServletRequest request) {
		return "user_information";
	}

	@RequestMapping(value = "/user_information_submit", method = GET)
	public String userInformationSubmit(Model model, 
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null)
			return "redirect:/index";
		
		String dorm = request.getParameter("dorm");
		
		user.setDorm(dorm);
		userService.update(user);
		user = userService.getById(user.getId());


		request.getSession().setAttribute("user", user);
		return "redirect:/center";
	}

}
