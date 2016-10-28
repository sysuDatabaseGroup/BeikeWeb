package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.BookCategory;
import com.databasegroup.service.IBookCategoryService;
import com.databasegroup.service.IBookService;
import com.databasegroup.service.IDealedBookService;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	@Autowired
	private IBookCategoryService bookCategoryService;
	
	@Autowired
	private IBookService bookService;
	
	@RequestMapping(value={"/","/index"},method=GET)
	public String index(Model model) {
		model.addAttribute("bookCategories", 
				bookCategoryService.getAll());
		model.addAttribute("bookInfos", 
				bookService.getNoSelledAndNoRentedBooks());
		return "index";
	}
	
}
