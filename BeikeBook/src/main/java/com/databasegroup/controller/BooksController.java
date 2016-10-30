package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.BookCategory;
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.SelledBookFromUser;
import com.databasegroup.model.User;
import com.databasegroup.service.IDealedBookService;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/books")
public class BooksController {

	@Autowired
	private IDealedBookService dealedBookService;
	
	@RequestMapping(method=GET)
	public String books(HttpServletRequest request,
			Model model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) return "login";
		List<DealedBook> noSelledDealedBooks = dealedBookService
				.getNoSelledBookByUserId(user.getId());
		List<DealedBook> selledDealedBooks = dealedBookService
				.getSelledBookByUserId(user.getId());
		model.addAttribute("noSelledDealedBooks", noSelledDealedBooks);
		model.addAttribute("selledDealedBooks", selledDealedBooks);
		return "books";
	}
}
