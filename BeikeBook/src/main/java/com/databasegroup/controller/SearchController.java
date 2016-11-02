package com.databasegroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.Book;
import com.databasegroup.model.BookCategory;
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.RentingOrder;
import com.databasegroup.model.SellingOrder;
import com.databasegroup.model.User;
import com.databasegroup.service.IBookService;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IEncashmentService;
import com.databasegroup.service.IRentingOrderService;
import com.databasegroup.service.ISellingOrderService;
import com.databasegroup.service.IUserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/search")
public class SearchController {
	
	@Resource
	private IBookService BookService;

	@RequestMapping(method = GET)
	public String search(
			HttpServletRequest request,
			Model model) {
		String bookCategoryIdStr = request.getParameter("bookCategoryId");
		int bookCategoryId = 0;
		try {  
			bookCategoryId = Integer.parseInt(bookCategoryIdStr);  
		} catch (NumberFormatException e) {  
			bookCategoryIdStr = null;
		}  
		String bookTitle = request.getParameter("bookTitle");
		List<Book> bookInfos = null;
		if (bookCategoryIdStr != null) {
			bookInfos = BookService.getByBookCategoryId(bookCategoryId);
		} else if (bookTitle != null) {
			bookInfos = BookService.getByBookTitle(bookTitle);
		}
		model.addAttribute("bookInfos", bookInfos);
		return "search";
	}
}
