package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.BookCategory;
import com.databasegroup.model.Order;
import com.databasegroup.model.RentingOrder;
import com.databasegroup.model.SellingOrder;
import com.databasegroup.model.User;
import com.databasegroup.service.IRentingOrderService;
import com.databasegroup.service.ISellingOrderService;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/buy_rent")
public class BuyRentController {
	
	@Autowired
	private IRentingOrderService rentingOrderService;
	
	@Autowired
	private ISellingOrderService sellingOrderService;
	
	@RequestMapping(method=GET)
	public String buyRent(HttpServletRequest request,
			Model model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) return "login";
		List<RentingOrder> rentingOrders = 
				rentingOrderService.getRentingOrdersByUserId(user.getId());
		List<SellingOrder> sellingOrders =
				sellingOrderService.getSellingOrdersByUserId(user.getId());
		List<Order> orders = new ArrayList<>();
		orders.addAll(rentingOrders);
		orders.addAll(sellingOrders);
		orders.sort(new Comparator<Order>() {

			@Override
			public int compare(Order o1, Order o2) {
				return o1.getDatetime().before(o2.getDatetime()) ?
						1 : 0;
			}
			
		});
		
		model.addAttribute("orders", orders);
		return "buy_rent";
	}
}