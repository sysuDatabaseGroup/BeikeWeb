package com.databasegroup.controller;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.databasegroup.model.Banner;
import com.databasegroup.model.BookCategory;
import com.databasegroup.service.IBannerService;
import com.databasegroup.service.IBookCategoryService;
import com.databasegroup.service.IBookService;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IUserService;
import com.databasegroup.utils.UploadFileUtil;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/backend")
public class AdminBannerController {
	
	private static final String PIC_FOLDER = "banner";
	
	@Resource
	private IBannerService bannerService;
	
	@RequestMapping(value="/banner",method=GET)
	public String banner(Model model) {
		List<Banner> banners = bannerService.getAll();
		model.addAttribute("banners", banners);
		model.addAttribute("page","banner/banner.jsp");
		return "/admin/layout";
	}
	
	@RequestMapping(value="/banner/{page}",method=GET)
	public String bannerPage(@PathVariable int page,
				Model model,
				HttpServletRequest request) {
		List<Banner> banners = bannerService.getAll();
		model.addAttribute("banners", banners);
		model.addAttribute("page","banner/banner.jsp");
		return "/admin/layout";
	}
	
	@RequestMapping(value="/banner_add",method=GET)
	public String bannerAdd(Model model) {
		model.addAttribute("page","banner/banneradd.jsp");
		return "/admin/layout";
	}
	
	@RequestMapping(value="/banner_edit/{id}",method=GET)
	public String bannerEdit(
			@PathVariable int id,
			Model model) {
		Banner banner = bannerService.getById(id);
		model.addAttribute("banner", banner);
		model.addAttribute("page","banner/banneredit.jsp");
		return "/admin/layout";
	}
	
	@RequestMapping(value="/banner_add",method=POST)
	public void bannerAddSubmit(
			Banner banner,
			@RequestParam("picFile") MultipartFile picFile,
			HttpServletResponse response,
			HttpServletRequest request) {
		
		UploadFileUtil uf = new UploadFileUtil(request);
		String filename = picFile.getOriginalFilename();
		
		String picPath = uf.saveFileToWeb(
				picFile, PIC_FOLDER, filename.substring(
				filename.lastIndexOf(".")));
		
		banner.setPicPath(picPath);
		bannerService.insert(banner);
		
		response.setContentType("text/html");
		try {
			response.getWriter().write("添加成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/banner_edit",method=POST)
	public void bannerEditSubmit(
			HttpServletRequest request,
			@RequestParam("picFile") MultipartFile picFile,
			Banner banner,
			HttpServletResponse response) {
		
		UploadFileUtil uf = new UploadFileUtil(request);
		String filename = picFile.getOriginalFilename();
		
		if (filename.length() == 0) {
			bannerService.updateExceptPic(banner);
		} else {
			String picPath = uf.saveFileToWeb(
					picFile, PIC_FOLDER, filename.substring(
					filename.lastIndexOf(".")));
			banner.setPicPath(picPath);
			bannerService.update(banner);
		}
		
		try {
			response.getWriter().write("修改成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/banner_delete",method=POST)
	public void bannerDeleteSubmit(
			HttpServletResponse response,
			@RequestParam int id) {
		bannerService.delete(id);
		try {
			response.getWriter().write("删除成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
