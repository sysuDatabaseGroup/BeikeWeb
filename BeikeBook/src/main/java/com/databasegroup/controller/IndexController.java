package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.Banner;
import com.databasegroup.model.BookCategory;
import com.databasegroup.service.IBannerService;
import com.databasegroup.service.IBookCategoryService;
import com.databasegroup.service.IBookService;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IUserService;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	@Autowired
	private IBookCategoryService bookCategoryService;
	
	@Autowired
	private IBannerService bannerService;
	
	@Autowired
	private IBookService bookService;
	
	@RequestMapping(value={"/","/index"},method=GET)
	public String index(Model model,
				HttpServletRequest request) {
		if (request.getSession().getAttribute("bookCategories") == null) {
		request.getSession().setAttribute("bookCategories",
				bookCategoryService.getAll());
		}
		List<Banner> banners = bannerService.getOrderByPrior();
		
		model.addAttribute("banners", banners);
		model.addAttribute("bookInfos", 
				bookService.getAll());
		return "index";
	}
	
}
