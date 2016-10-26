package com.databasegroup.controller.fortest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import com.databasegroup.model.City;
import com.databasegroup.service.ICityService;

@Controller
@RequestMapping("/showCity")
public class CityController {
	
	@Autowired
    private ICityService cityService;
	
	@RequestMapping(method=GET)
	public String getCity(HttpServletRequest request, Model model) {
		String cityNum = request.getParameter("cityNum");
		model.addAttribute("cities", 
				cityService.getCityByCityNum(cityNum));
		return "/fortest/showCity";
	}
}
