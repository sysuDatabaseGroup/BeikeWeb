package com.databasegroup.controller;
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
		City city = new City();
		int cityID = Integer.valueOf(request.getParameter("cityID"));
		city.setCityID(cityID);
		model.addAttribute("cityName", 
				cityService.getById(city.getCityID()).getCityName());
		
		return "/fortest/showCity";
	}
}
