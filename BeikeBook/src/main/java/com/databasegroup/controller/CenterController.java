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
import com.databasegroup.model.RentingOrder;
import com.databasegroup.model.SellingOrder;
import com.databasegroup.model.User;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IEncashmentService;
import com.databasegroup.service.IRentingOrderService;
import com.databasegroup.service.ISellingOrderService;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/center")
public class CenterController {

	@Autowired
	private IEncashmentService encashmentService;
	
	@Autowired
	private IDealedBookService dealedBookService;
	
	@Autowired
	private IRentingOrderService rentingOrderService;
	
	@Autowired
	private ISellingOrderService sellingOrderService;

	@RequestMapping(method = GET)
	public String center(
			HttpServletRequest request, 
			Model model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) return "login";
		List<RentingOrder> rentingOrders = 
				rentingOrderService.getRentingOrdersByUserId(user.getId());
		List<SellingOrder> sellingOrders =
				sellingOrderService.getSellingOrdersByUserId(user.getId());
		int amountOfboughtAndRentedBook = rentingOrders.size()
				+sellingOrders.size();
		double encashingAmount = encashmentService
				.getEncashingAmountById(user.getId());
		int amountOfBook = dealedBookService
				.getAmountOfBookUserId(user.getId());
		model.addAttribute("user", user);
		model.addAttribute("encashingAmount", encashingAmount);
		model.addAttribute("amountOfBook", amountOfBook);
		model.addAttribute("amountOfboughtAndRentedBook", 
				amountOfboughtAndRentedBook);
		
		return "center";
	}
}
