package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.BookCategory;
import com.databasegroup.model.Encashment;
import com.databasegroup.model.User;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IEncashmentService;
import com.databasegroup.service.IUserService;
import com.databasegroup.service.impl.TransactionMethod;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/alipay")
public class AlipayController {
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IEncashmentService encashmentService;
	
	@Resource
	private IDealedBookService dealedBookService;
	
	@Resource
	private TransactionMethod transactionMethod;
	
	@RequestMapping(method=GET)
	public String alipay(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) return "login";
		user = userService.updateUserEncashingAmount(user.getId());
		request.getSession()
				.setAttribute("user", 
				user);
		return "alipay";
	}
	
	@RequestMapping(method=POST)
	public String encashing(HttpServletRequest request,
			@RequestParam String alipayAccount,
			@RequestParam String alipayName,
			@RequestParam String phone,
			Model model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) return "login";
			Encashment encashment = new Encashment();
			encashment.setAlipayAccount(alipayAccount);
			encashment.setAlipayName(alipayName);
			encashment.setPhone(phone);
			
			// 事务处理
			if (transactionMethod
					.insertEncashment(encashment, user.getId())) {
			user.setWithdrawalAmount(0);
			request.getSession().setAttribute("user", user);
			model.addAttribute("message", "提现成功！");
		} else {
			model.addAttribute("message", "金额不足，不得提现！");
		}
		return "alipay";
	}
}