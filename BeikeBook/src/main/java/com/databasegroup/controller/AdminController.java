package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.text.*;
import java.security.MessageDigest; 
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databasegroup.model.*;
import com.databasegroup.service.*;
import com.databasegroup.service.impl.*;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backend")
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
	@Autowired
	private IAdminService adminService;

	@RequestMapping(value="/index",method=GET)
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("loginStatus",true);
		model.addAttribute("roleType",(String)request.getSession().getAttribute("roleType"));
		String name = (String)request.getSession().getAttribute("adminUserName");
		String districtAddr = (String)request.getSession().getAttribute("districtAddr");
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
			DealedBook dealedBook = rent.getDealedBook();
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
			DealedBook dealedBook = sell.getDealedBook();
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
	
	@RequestMapping(value="/login",method={GET,POST})
	public String login(Model model, HttpServletRequest request) throws Exception{
		String get = new String("GET");
		if(request.getMethod().equals(get)){
			return "/admin/sign-in";
		}
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] buf = md.digest(password.getBytes());
		BASE64Encoder encoder = new BASE64Encoder();
		String encode_pw = encoder.encode(buf);
		Admin admin = adminService.getByName(name);
		if(admin == null){
			model.addAttribute("error_msg","用户不存在");
			return "/admin/sign-in";
		}
		if(!admin.getPassword().equals(encode_pw)){
			model.addAttribute("error_msg","密码不正确");
			return "/admin/sign-in";
		}
		request.getSession().setAttribute("adminUserName",name);
		request.getSession().setAttribute("districtAddr",admin.getDistrict());
		request.getSession().setAttribute("roleType",String.valueOf(admin.getType()));
		//response.sendRedirect(request.getContextPath() + "/admin/index");
		return "redirect:/backend/index";
	}
	
	@RequestMapping(value="/logout",method={GET,POST})
	public String logout(HttpServletRequest request) {
		request.getSession().setAttribute("adminUserName",null);
		request.getSession().setAttribute("districtAddr",null);
		request.getSession().setAttribute("roleType",null);
		return "redirect:/backend/login";
	}
	
	@RequestMapping(value="/userList",method=GET)
	public String userList(Model model, HttpServletRequest request) {
		int curPageNo = request.getParameter("pageNo") == null? 1:Integer.parseInt(request.getParameter("pageNo"));
		model.addAttribute("pageNo",curPageNo);
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		List<User> users = userService.getLimitUsers((curPageNo-1)*10,20);
		int numOfItem = users.size() > 5? 5:users.size();
		model.addAttribute("numOfItem",numOfItem);
		int maxPage = users.size() / 5 + curPageNo;
		if(users.size() % 5 == 0){
			maxPage = maxPage - 1;
		}
		model.addAttribute("maxPage",maxPage);
		List<HashMap<String,String> > userinfos = new ArrayList<HashMap<String,String> >();
		for(User user:users){
			HashMap<String,String> m = new HashMap<String,String>();
			m.put("id",user.getId() + "");
			m.put("userNum",user.getUserNum());
			m.put("cityName",user.getCity().getName());
			m.put("schoolName",user.getSchool().getName());
			m.put("dorm",user.getDorm());
			userinfos.add(m);
		}
		model.addAttribute("userInfos",userinfos);
		int beginPage = maxPage >= 4? maxPage - 3:1;
		model.addAttribute("beginPage",beginPage);
		return "/admin/user/users";
	}

}
