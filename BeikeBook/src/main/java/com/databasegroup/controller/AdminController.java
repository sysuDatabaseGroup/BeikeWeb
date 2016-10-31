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
import org.springframework.web.bind.annotation.ResponseBody;

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
	@Autowired
	private ICityService cityService;
	@Autowired
	private ISchoolService schoolService;

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
			List<DealedBook> dealedBooks = rent.getDealedBooks();
			if(dealedBooks != null){
				for(DealedBook dealedBook:dealedBooks){
					totalAmount = totalAmount + dealedBook.getRentalPrice();
				}
			}
			Book book = bookService.getById(rent.getBookId());
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
			List<DealedBook> dealedBooks = sell.getDealedBooks();
			for(DealedBook dealedBook:dealedBooks){
				totalAmount = totalAmount + dealedBook.getRentalPrice();
			}
			double sellPrice = dealedBooks.get(0).getSellingPrice();
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
		List<User> users = userService.getLimitUsers((curPageNo-1)*5,20);
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
	
	@RequestMapping(value="/useredit",method=GET)
	public String showUser(Model model,HttpServletRequest request) {
		if(request.getParameter("userNo") == null){
			return "/admin/404";
		}
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		User user = userService.getById(userNo);
		if(user == null){
			return "/admin/404";
		}
		List<City> cities = cityService.getAll();
		List<School> schools = schoolService.getAll();
		List<HashMap<String,String> > citiesMap = new ArrayList<HashMap<String,String> >();
		List<HashMap<String,String> > schoolMap = new ArrayList<HashMap<String,String> >();
		for(City city:cities){
			HashMap<String,String> m = new HashMap<String,String>();
			m.put("id",String.valueOf(city.getId()));
			m.put("name",city.getName());
			citiesMap.add(m);
		}
		for(School school:schools){
			HashMap<String,String> m = new HashMap<String,String>();
			m.put("id",String.valueOf(school.getId()));
			m.put("name",school.getName());
			schoolMap.add(m);
		}
		model.addAttribute("cities",citiesMap);
		model.addAttribute("schools",schoolMap);
		model.addAttribute("schoolNum",user.getSchoolId());
		model.addAttribute("cityNum",user.getCityId());
		model.addAttribute("userNum",user.getUserNum());
		model.addAttribute("dorm",user.getDorm());
		model.addAttribute("userNo",userNo);
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		return "/admin/user/useredit";
	}
	
	@ResponseBody
	@RequestMapping(value="/saveUser",method=POST,produces="text/html;charset=UTF-8")
	public String saveUser(Model model,HttpServletRequest request) {
		try{
			request.setCharacterEncoding("UTF-8");
			if(request.getParameter("userNo") == null){
				return "{\"code\": 1,\"msg\":\"missing userNo\"}";
			}
			int userNo = Integer.parseInt(request.getParameter("userNo"));
			User user = userService.getById(userNo);
			if(user == null){
				return "{\"code\": 2,\"msg\" :\"the user do not exists\"}";
			}
			String cityId = request.getParameter("city");
			String schoolId = request.getParameter("school");
			String dorm = request.getParameter("dorm");
			if(cityId == null||schoolId == null||dorm == null){
				return "{\"code\": 3,\"msg\"\"missing some parameter\"}";
			}
			//City city = cityService.getById(Integer.parseInt(cityId));
			//School school = schoolService.getById(Integer.parseInt(schoolId));
			//user.setCity(city);
			user.setCityId(Integer.parseInt(cityId));
			//user.setSchool(school);
			user.setSchoolId(Integer.parseInt(schoolId));
			user.setDorm(dorm);
			userService.update(user);
			return "{\"code\": 0,\"msg\":\"\"}";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
		}
	}
	
	@RequestMapping(value="/cityList", method=GET)
	public String cityList(Model model, HttpServletRequest request) {
		int curPageNo = request.getParameter("pageNo") == null? 1:Integer.parseInt(request.getParameter("pageNo"));
		model.addAttribute("pageNo",curPageNo);
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		List<City> cities = cityService.getLimitCities((curPageNo-1)*5,20);
		int numOfItem = cities.size() > 5? 5:cities.size();
		model.addAttribute("numOfItem",numOfItem);
		int maxPage = cities.size() / 5 + curPageNo;
		if(cities.size() % 5 == 0){
			maxPage = maxPage - 1;
		}
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("cityInfos",cities);
		int beginPage = maxPage >= 4? maxPage - 3:1;
		model.addAttribute("beginPage",beginPage);
		return "/admin/city/city";
	}

}
