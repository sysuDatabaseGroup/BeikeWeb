package com.databasegroup.fortest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import com.databasegroup.fortest.pojo.City;
import com.databasegroup.fortest.service.ICityService;

@Controller
@RequestMapping("/showCity")
public class CityController {
	
	@Autowired
    private ICityService cityService;
	
	@RequestMapping(method=GET)
	public String getCity(HttpServletRequest request, Model model) {
		City city = new City();
		String cityNum = request.getParameter("cityNum");
		city.setCityNum(cityNum);
		model.addAttribute("cityName", 
				cityService.getCity(city).getCityName());
		
		return "/fortest/showCity";
	}
}
