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
import com.databasegroup.model.District;
import com.databasegroup.model.DistrictStoredSituation;
import com.databasegroup.model.User;
import com.databasegroup.service.IBookService;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IDistrictService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

@Controller
@RequestMapping(value = "/detail")
public class DetailController {

	@Autowired
	private IDealedBookService dealedBookService;

	@Autowired
	private IDistrictService districtService;
	
	@Autowired
	private IBookService bookService;

	@RequestMapping(value = "/{id}", method = GET)
	public String detail(@PathVariable int id, HttpServletRequest request, Model model) {
		DealedBook dealedBook = dealedBookService
				.getNoSelledAndNoRentedBookByBookId(id);
		int dealedBookId = dealedBook == null ? -1 : dealedBook.getId();
		model.addAttribute("dealedBookId", dealedBookId);
		model.addAttribute("bookInfo", bookService.getById(id));
		List<DistrictStoredSituation> districtSituation = 
				districtService.getSituationByBookId(id);
		model.addAttribute("districtSituation", 
				districtSituation);
		return "detail";
	}
}