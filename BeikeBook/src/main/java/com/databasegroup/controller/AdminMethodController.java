package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databasegroup.model.BookCategory;
import com.databasegroup.model.DeliveryMethod;
import com.databasegroup.service.IBookCategoryService;
import com.databasegroup.service.IBookService;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IDeliveryMethodService;
import com.databasegroup.service.IUserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/backend")
public class AdminMethodController {
	
	@Resource
	private IDeliveryMethodService deliveryMethodService;
	
	@RequestMapping(value="/method",method=GET)
	public String method(Model model,
				HttpServletRequest request) {
		List<DeliveryMethod> methods = deliveryMethodService.getAll();
		model.addAttribute("methods", methods);
		return "/admin/method/method";
	}
	
	@RequestMapping(value="/method/{page}",method=GET)
	public String methodPage(@PathVariable int page,
				Model model,
				HttpServletRequest request) {
		List<DeliveryMethod> methods = deliveryMethodService.getAll();
		model.addAttribute("methods", methods);
		return "/admin/method/method";
	}
	
	@RequestMapping(value="/method_add",method=GET)
	public String methodAdd(Model model,
				HttpServletRequest request) {
		return "/admin/method/methodadd";
	}
	
	@RequestMapping(value="/method_edit/{id}",method=GET)
	public String methodEdit(
			@PathVariable int id,
			Model model,
			HttpServletRequest request) {
		DeliveryMethod method = deliveryMethodService.getById(id);
		model.addAttribute("method", method);
		return "/admin/method/methodedit";
	}
	
	@RequestMapping(value="/method_add",method=POST)
	public void methodAddSubmit(
			DeliveryMethod method,
			HttpServletResponse response) {
		deliveryMethodService.insert(method);
		try {
			response.getWriter().write("添加成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/method_edit",method=POST)
	public void methodEditSubmit(
			HttpServletResponse response,
			DeliveryMethod method) {
		deliveryMethodService.update(method);
		try {
			response.getWriter().write("修改成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/method_delete",method=POST)
	public void methodDeleteSubmit(
			HttpServletResponse response,
			@RequestParam int id) {
		deliveryMethodService.delete(id);
		try {
			response.getWriter().write("删除成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
