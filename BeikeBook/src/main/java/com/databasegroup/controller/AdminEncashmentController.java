package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.BookCategory;
import com.databasegroup.model.Encashment;
import com.databasegroup.service.IBookCategoryService;
import com.databasegroup.service.IBookService;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IEncashmentService;
import com.databasegroup.service.IUserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/backend")
public class AdminEncashmentController {
	
	@Resource
	private IEncashmentService encashmentService;
	
	@RequestMapping(value="/encashment",method=GET)
	public String encashment(Model model,
				HttpServletRequest request) {
		List<Encashment> encashments = encashmentService.getNoEncashed();
		model.addAttribute("encashments", encashments);
		return "/admin/encashment/encashment";
	}
	
	@RequestMapping(value="/all_encashment",method=GET)
	public String allEncashment(Model model,
				HttpServletRequest request) {
		List<Encashment> encashments = encashmentService.getEncashed();
		model.addAttribute("encashments", encashments);
		return "/admin/encashment/all_encashment";
	}
	
	@RequestMapping(value="/all_encashment_search",method=GET)
	public String allEncashmentSearch(Model model,
				@RequestParam String alipayAccount) {
		List<Encashment> encashments = encashmentService
				.getEncashedByAlipayAccount(alipayAccount);
		model.addAttribute("encashments", encashments);
		return "/admin/encashment/all_encashment";
	}
	
}
