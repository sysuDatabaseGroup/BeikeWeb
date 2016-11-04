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
import com.databasegroup.service.IDealedBookService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/pay")
public class PayController {

	@Autowired
	IDealedBookService dealedBookService;
	
	@RequestMapping(value="/{dealedBookId}",method = GET)
	public String pay(@PathVariable int dealedBookId,
			HttpServletRequest request,
			Model model) {
		DealedBook dealedBook = 
				dealedBookService.getById(dealedBookId);
		if (dealedBook == null) return "redirect:/index";
		int amountOfBooks = dealedBookService
				.getAmountOfNoDealedBookBookId(dealedBook.getBook().getId());
		model.addAttribute("dealedBook", dealedBook);
		model.addAttribute("amountOfBooks", amountOfBooks);
		return "pay";
	}
}
