package com.databasegroup.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.BookCategory;
import com.databasegroup.service.IBookService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

@Controller
@RequestMapping(value = "/detail")
public class DetailController {
	
	@Autowired
	private IBookService bookService;

	@RequestMapping(value="/{bookId}",method = GET)
	public String detail(@PathVariable int bookId,
				Model model) {
		model.addAttribute("book", bookService.getById(bookId));
		return "detail";
	}
}