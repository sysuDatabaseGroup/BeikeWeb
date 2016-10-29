package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.text.*;
import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.*;
import com.databasegroup.service.*;
import com.databasegroup.service.impl.*;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IRentingOrderService rentingOrderService;
	@Autowired
	private ISellingOrderService sellingOrderService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IBillService billService;
	@Autowired
	private IBookService bookService;
	@Autowired
	private IDealedBookService dealedBookService;
	@Autowired
	private IAnnounService announService;

	@RequestMapping(value="/index",method=GET)
	public String index(Model model, HttpServletRequest request) {
		/*String login_status = httpSession.getAttribute("adminLoginStatus");
		if(login_status=="0"){
			return "/admin/sign-in";
		}*/
		model.addAttribute("loginStatus",true);
		String name = request.getSession().getAttribute("adminUserName") == null? "root":(String)request.getSession().getAttribute("adminUserName");
		String districtAddr = request.getSession().getAttribute("districtAddr") == null? "hello":(String)request.getSession().getAttribute("districtAddr") ;
		model.addAttribute("districtAddrStr",districtAddr);
		List<RentingOrder> rentingOrders = rentingOrderService.getAll();
		model.addAttribute("numRentBook",rentingOrders.size());
		List<SellingOrder> sellingOrders= sellingOrderService.getAll();
		model.addAttribute("numSellBook",sellingOrders.size());
		List<User> userModels = userService.getAll();
		model.addAttribute("numUsers",userModels.size());
		Date dateTime = new Date();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		model.addAttribute("dataTime",time.format(dateTime));
		double totalAmount = 0;
		model.addAttribute("circulatingFund",totalAmount);
		List<HashMap<String , String> > rentinfos = new ArrayList<HashMap<String,String> >();
		for(RentingOrder rent:rentingOrders){
			int userId = rent.getUserId();
			String userNum = userService.getById(userId).getUserNum();
			int dealedBookId = rent.getDealedBookId();
			DealedBook dealedBook = dealedBookService.getById(dealedBookId);
			totalAmount = totalAmount + dealedBook.getRentalPrice();
			Book book = dealedBook.getBook();
			String bookClassName = book.getTitle();
			int took = rent.getTook();
			String isTake = took == 0? "否":"是";
			HashMap<String,String> m = new HashMap<String,String>();
			m.put("userNum",userNum);
			m.put("bookClassName",bookClassName);
			m.put("isTake",isTake);
			rentinfos.add(m);
		}
		model.addAttribute("rentInfos",rentinfos);
		List<HashMap<String,String> > sellInfos = new ArrayList<HashMap<String,String> >();
		for(SellingOrder sell:sellingOrders){
			int userId = sell.getUserId();
			String userNum = userService.getById(userId).getUserNum();
			int dealedBookId = sell.getDealedBookId();
			DealedBook dealedBook = dealedBookService.getById(dealedBookId);
			totalAmount = totalAmount + dealedBook.getSellingPrice();
			double sellPrice = dealedBook.getSellingPrice();
			Date sellTime = sell.getDatetime();
			String datetime = time.format(sellTime);
			HashMap<String,String> m = new HashMap<String,String>();
			m.put("userNum",userNum);
			m.put("sellPrice",Double.toString(sellPrice));
			m.put("datetime",datetime);
			sellInfos.add(m);
		}
		model.addAttribute("sellInfos",sellInfos);
		List<Announ> announs = announService.getAll();
		String announContent = announs.get(announs.size()-1).getContent();
		model.addAttribute("announContent",announContent);

		return "/admin/index";
	}
	
}
