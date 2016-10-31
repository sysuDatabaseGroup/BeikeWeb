package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.BookCategory;
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.District;
import com.databasegroup.model.RentingOrder;
import com.databasegroup.model.SellingOrder;
import com.databasegroup.model.User;
import com.databasegroup.service.IDeliveryMethodService;
import com.databasegroup.service.IDistrictService;
import com.databasegroup.service.IRentingOrderService;
import com.databasegroup.service.ISellingOrderService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SuccessController {

	@Autowired
	private ISellingOrderService sellingOrderService;
	@Autowired
	private IRentingOrderService rentingOrderService;
	@Autowired
	private IDistrictService districtService;

	@RequestMapping(value = "/success", method = POST)
	public String success(HttpServletRequest request,
			@RequestParam int bookNum_input,
			Model model) {
		DealedBook dealedBook = (DealedBook) request.getSession()
				.getAttribute("dealedBook");
		User user = (User) request.getSession().getAttribute("user");
		SellingOrder sellingOrder = new SellingOrder();
		District district = districtService
				.getById(dealedBook.getDistrictId());
		int delieryMethodId = Integer.parseInt(
				request.getParameter("delieryMethodId"));
		
		sellingOrder.setUserId(user.getId());
		sellingOrder.setDeliveryMethodId(delieryMethodId);  //
		sellingOrder.setBookId(dealedBook.getBookId());  //
		sellingOrder.setAmount(bookNum_input);
		sellingOrder.setDatetime(new Date());
		sellingOrder.setPayed(1);
		// 取书号：学校编号+日期+待售书的ID
		sellingOrder.setTakingBookNum( "" +
				user.getSchool().getNum() +
				new SimpleDateFormat("yyyyMMdd").format(new Date()) +
				String.format("%05d", dealedBook.getId())
					);
		
		
		sellingOrderService.insertOrder(sellingOrder);
		
		model.addAttribute("district", district);
		model.addAttribute("dealedBook", dealedBook);
		model.addAttribute("sellingOrder", sellingOrder);
		model.addAttribute("bookNum_input", bookNum_input);
		
		return "success";
	}
	
	@RequestMapping(value = "/success_rent", method = POST)
	public String success_rent(HttpServletRequest request,
			@RequestParam int bookNum_input,
			Model model) {
		DealedBook dealedBook = (DealedBook) request.getSession()
				.getAttribute("dealedBook");
		User user = (User) request.getSession().getAttribute("user");
		District district = districtService
				.getById(dealedBook.getDistrictId());
		int delieryMethodId = Integer.parseInt(
				request.getParameter("delieryMethodId"));

		RentingOrder rentingOrder = new RentingOrder();
		rentingOrder.setUserId(user.getId());
		rentingOrder.setDeliveryMethodId(delieryMethodId);  //
		rentingOrder.setBookId(dealedBook.getBookId());
		rentingOrder.setAmount(bookNum_input);
		rentingOrder.setDatetime(new Date());
		rentingOrder.setTakingBookNum( "" +
				user.getSchool().getNum() +
				new SimpleDateFormat("yyyyMMdd").format(new Date()) +
				String.format("%05d", dealedBook.getId())
					);
		rentingOrder.setTook(1);
		rentingOrder.setReturned(1);
		
		rentingOrderService.insertOrder(rentingOrder);
		
		model.addAttribute("district", district);
		model.addAttribute("dealedBook", dealedBook);
		model.addAttribute("rentingOrder", rentingOrder);
		model.addAttribute("bookNum_input", bookNum_input);
		
		return "success_rent";
	}
	
}