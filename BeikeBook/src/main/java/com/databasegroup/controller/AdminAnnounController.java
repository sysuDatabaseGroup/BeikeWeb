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

import com.databasegroup.model.Announ;
import com.databasegroup.model.BookCategory;
import com.databasegroup.service.IAnnounService;
import com.databasegroup.service.IBookCategoryService;
import com.databasegroup.service.IBookService;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IUserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/backend")
public class AdminAnnounController {
	
	@Resource
	private IAnnounService announService;
	
	@RequestMapping(value="/announ",method=GET)
	public String announ(
				Model model,
				HttpServletRequest request) {
		List<Announ> announs = announService.getAll();
		model.addAttribute("announs", announs);
		return "/admin/announ/announ";
	}
	
	@RequestMapping(value="/announ/{page}",method=GET)
	public String announPage(@PathVariable int page,
				Model model,
				HttpServletRequest request) {
		List<Announ> announs = announService.getAll();
		model.addAttribute("announs", announs);
		return "/admin/announ/announ";
	}
	
	@RequestMapping(value="/announ_add",method=GET)
	public String announAdd(Model model,
				HttpServletRequest request) {
		return "/admin/announ/announadd";
	}
	
	@RequestMapping(value="/announ_edit/{id}",method=GET)
	public String announEdit(
			@PathVariable int id,
			Model model,
			HttpServletRequest request) {
		Announ announ = announService.getById(id);
		model.addAttribute("announ", announ);
		return "/admin/announ/announedit";
	}
	
	@RequestMapping(value="/announ_add",method=POST)
	public void announAddSubmit(
			Announ announ,
			HttpServletResponse response) {
		announService.insert(announ);
		try {
			response.getWriter().write("添加成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/announ_edit",method=POST)
	public void announEditSubmit(
			HttpServletResponse response,
			Announ announ) {
		announService.update(announ);
		try {
			response.getWriter().write("修改成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/announ_delete",method=POST)
	public void announDeleteSubmit(
			HttpServletResponse response,
			@RequestParam int id) {
		announService.delete(id);
		try {
			response.getWriter().write("删除成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
