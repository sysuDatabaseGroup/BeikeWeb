package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.text.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databasegroup.model.*;
import com.databasegroup.service.*;
import com.databasegroup.service.impl.*;
import com.databasegroup.utils.uploadFile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	@Autowired
	private IDistrictService districtService;
	@Autowired
	private IBookCategoryService bookCategoryService;
	@Autowired
	private IDeliveryMethodService deliveryMethodService;

	private String str2MD5(String msg) throws Exception{
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] buf = md.digest(msg.getBytes());
		BASE64Encoder encoder = new BASE64Encoder();
		String encode_msg = encoder.encode(buf);
		return encode_msg;
	}

    private String getFullUrl(HttpServletRequest request){
        String url = "";
        url = request.getScheme() +"://" + request.getServerName()  
                        + ":" +request.getServerPort() 
                        + request.getServletPath();
        if (request.getQueryString() != null){
            url += "?" + request.getQueryString();
			url += "&";
        }
		else{
			url += "?";
		}
        return url;
    }


	@RequestMapping(value={"/index", "/"},method=GET)
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
		model.addAttribute("page","index.jsp");
		return "/admin/layout";
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
		String encode_pw = str2MD5(password);
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
		model.addAttribute("page","user/users.jsp");
		return "/admin/layout";
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
		model.addAttribute("page","user/useredit.jsp");
		return "/admin/layout";
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
		String roleType = (String)request.getSession().getAttribute("roleType");
		if(Integer.parseInt(roleType) != 0){
			return "/admin/404";
		}
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
		model.addAttribute("page","city/city.jsp");
		return "/admin/layout";
	}

	@RequestMapping(value="/cityadd",method={GET,POST})
	public String cityAdd(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		if(Integer.parseInt(roleType) != 0){
			return "/admin/404";
		}
		model.addAttribute("page","city/cityadd.jsp");
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		String get = new String("GET");
		if(request.getMethod().equals(get)){
			return "/admin/layout";
		}
		try{
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String num = request.getParameter("num");
			if(name == null||num == null||
				name.length() == 0||num.length() == 0){
				model.addAttribute("error_msg","请填写所有信息");
				return "/admin/layout";
			}
			City city = new City();
			city.setName(name);
			city.setNum(num);
			cityService.insert(city);
			model.addAttribute("success_msg","添加成功！");
			return "/admin/layout";
		}catch(Exception e){
			return "/admin/404";
		}
	}

	@RequestMapping(value="/cityedit", method=GET)
	public String cityEdit(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		if(Integer.parseInt(roleType) != 0){
			return "/admin/404";
		}
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		model.addAttribute("page","city/cityedit.jsp");
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null){
				return "/admin/404";
			}
			int id = Integer.parseInt(str_id);
			City city = cityService.getById(id);
			if(city == null){
				return "/admin/404";
			}
			model.addAttribute("cityName",city.getName());
			model.addAttribute("cityAbbreviate",city.getNum());
			model.addAttribute("id",str_id);
			return "/admin/layout";
		}catch(Exception e){
			return "/admin/404";
		}
	}

	@ResponseBody
	@RequestMapping(value="/savecity",method=POST,produces = {"application/json;charset=UTF-8"})
	public String saveCity(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		if(Integer.parseInt(roleType) != 0){
			return "/admin/404";
		}
		try{
			request.setCharacterEncoding("UTF-8");
			//model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
			//model.addAttribute("page","city/cityedit.")
			String str_id = request.getParameter("id");
			String name = request.getParameter("name");
			String num = request.getParameter("num");
			if(str_id == null||name == null||num == null||
				str_id.length() == 0||name.length() == 0||num.length() == 0){
				return "{\"code\": 1, \"msg\": \"缺少信息\"}";
			}
			int id = Integer.parseInt(str_id);
			City city = cityService.getById(id);
			if(city == null){
				return "{\"code\": 2, \"msg\": \"城市不存在\"}";
			}
			city.setName(name);
			city.setNum(num);
			cityService.update(city);
			return "{\"code\": 0,\"msg\": \"\"}";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
		}
	}

	@ResponseBody
	@RequestMapping(value="/deletecity",method=POST,produces = {"application/json;charset=UTF-8"})
	public String deleteCity(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		if(Integer.parseInt(roleType) != 0){
			return "/admin/404";
		}
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null||str_id.length() == 0){
				return "{\"code\": 1, \"msg\": \"缺少id\"}";
			}
			int id = Integer.parseInt(str_id);
			City city = cityService.getById(id);
			if(city == null){
				return "{\"code\": 2, \"msg\": \"城市不存在\"}";
			}
			schoolService.deleteByCityId(id);
			cityService.delete(id);
			return "{\"code\": 0,\"msg\": \"\"}";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
		}
	}

	@RequestMapping(value="/schoolList", method=GET)
	public String schoolList(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		if(Integer.parseInt(roleType) != 0){
			return "/admin/404";
		}
		int curPageNo = request.getParameter("pageNo") == null? 1:Integer.parseInt(request.getParameter("pageNo"));
		model.addAttribute("pageNo",curPageNo);
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		List<School> schools = schoolService.getLimitSchools((curPageNo-1)*5,20);
		if(schools == null){
			schools = new ArrayList<School>();
		}
		int numOfItem = schools.size() > 5? 5:schools.size();
		model.addAttribute("numOfItem",numOfItem);
		int maxPage = schools.size() / 5 + curPageNo;
		if(schools.size() % 5 == 0){
			maxPage = maxPage - 1;
		}
		HashMap<Integer,String> cities = new HashMap<Integer,String>();
		for(School school:schools){
			City city = cityService.getById(school.getCityId());
			cities.put(school.getId(),city.getName());
		}
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("schoolInfos",schools);
		model.addAttribute("cities",cities);
		int beginPage = maxPage >= 4? maxPage - 3:1;
		model.addAttribute("beginPage",beginPage);
		model.addAttribute("page","city/school.jsp");
		return "/admin/layout";
	}

	@RequestMapping(value="/schooladd",method={GET,POST})
	public String schoolAdd(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		if(Integer.parseInt(roleType) != 0){
			return "/admin/404";
		}
		model.addAttribute("page","city/schooladd.jsp");
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		model.addAttribute("roleType",(String)request.getSession().getAttribute("roleType"));
		List<City> cities = cityService.getAll();
		model.addAttribute("cityInfos",cities);
		String get = new String("GET");
		if(request.getMethod().equals(get)){
			return "/admin/layout";
		}
		try{
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String num = request.getParameter("num");
			String cityId = request.getParameter("city");
			String adminName = request.getParameter("admin");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repassword");
			if(name == null||num == null||cityId == null||adminName == null||password == null||repassword == null||
				name.length() == 0||num.length() == 0||cityId.length() == 0||adminName.length() == 0||password.length() == 0||repassword.length() == 0){
				model.addAttribute("error_msg","请填写所有信息");
				return "/admin/layout";
			}
			City city = cityService.getById(Integer.parseInt(cityId));
			if(city == null){
				model.addAttribute("error_msg","城市不存在");
				return "/admin/layout";
			}
			Admin admin = adminService.getByName(adminName);
			if(admin != null){
				model.addAttribute("error_msg","该账户已存在");
				return "/admin/layout";
			}
			if(!password.equals(repassword)){
				model.addAttribute("error_msg","两次密码输入不一致");
				return "/admin/layout";
			}
			School school = new School();
			String encode_pw = str2MD5(password);
			Admin newAdmin = new Admin(adminName,encode_pw,name,1);
			school.setName(name);
			school.setNum(num);
			school.setAdmin(adminName);
			school.setCityId(Integer.parseInt(cityId));
			schoolService.insert(school);
			adminService.insert(newAdmin);
			model.addAttribute("success_msg","添加成功！");
			return "/admin/layout";
		}catch(Exception e){
			//String msg = e.toString();
			//msg = msg.replace("\"","\\\"");
			//model.addAttribute("error_msg","");
			return "/admin/404";
		}
	}

	@RequestMapping(value="/schooledit", method=GET)
	public String schoolEdit(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		if(Integer.parseInt(roleType) != 0){
			return "/admin/404";
		}
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		model.addAttribute("page","city/schooledit.jsp");
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null){
				return "/admin/404";
			}
			int id = Integer.parseInt(str_id);
			School school = schoolService.getById(id);
			if(school == null){
				return "/admin/404";
			}
			List<City> cities = cityService.getAll();
			model.addAttribute("schoolId",school.getId());
			model.addAttribute("schoolName",school.getName());
			model.addAttribute("schoolNum",school.getNum());
			model.addAttribute("cityId",school.getCityId());
			model.addAttribute("schoolAdmin",school.getAdmin());
			model.addAttribute("cities",cities);
			return "/admin/layout";
		}catch(Exception e){
			return "/admin/404";
		}
	}

	@ResponseBody
	@RequestMapping(value="/saveschool",method=POST,produces = {"application/json;charset=UTF-8"})
	public String saveSchool(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		if(Integer.parseInt(roleType) != 0){
			return "/admin/404";
		}
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			String name = request.getParameter("name");
			String num = request.getParameter("num");
			String cityId = request.getParameter("city");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repassword");
			if(str_id == null||name == null||num == null||cityId == null||
				str_id.length() == 0||name.length() == 0||num.length() == 0||cityId.length() == 0){
				return "{\"code\": 1, \"msg\": \"缺少信息\"}";
			}
			int id = Integer.parseInt(str_id);
			School school = schoolService.getById(id);
			if(school == null){
				return "{\"code\": 2, \"msg\": \"该学校不存在\"}";
			}
			City city = cityService.getById(Integer.parseInt(cityId));
			if(city == null){
				return "{\"code\": 2, \"msg\": \"城市不存在\"}";
			}
			if(password != null&&password.length() > 0){
				if(!password.equals(repassword)){
					return "{\"code\": 3, \"msg\": \"两次密码输入不一致\"}";
				}
				Admin admin = adminService.getByName(school.getAdmin());
				String encode_pw = str2MD5(password);
				admin.setPassword(encode_pw);
				adminService.update(admin);
			}
			school.setName(name);
			school.setNum(num);
			school.setCityId(Integer.parseInt(cityId));
			schoolService.update(school);
			return "{\"code\": 0,\"msg\": \"\"}";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
		}
	}

	@ResponseBody
	@RequestMapping(value="/deleteschool",method=POST,produces = {"application/json;charset=UTF-8"})
	public String deleteSchool(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		if(Integer.parseInt(roleType) != 0){
			return "/admin/404";
		}
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null||str_id.length() == 0){
				return "{\"code\": 1, \"msg\": \"缺少id\"}";
			}
			int id = Integer.parseInt(str_id);
			School school = schoolService.getById(id);
			if(school == null){
				return "{\"code\": 2, \"msg\": \"该学校不存在\"}";
			}
			districtService.deleteBySchoolId(id);
			adminService.deleteByName(school.getAdmin());
			schoolService.delete(id);
			return "{\"code\": 0,\"msg\": \"\"}";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
		}
	}

	@RequestMapping(value="/districtList", method=GET)
	public String districtList(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		int curPageNo = request.getParameter("pageNo") == null? 1:Integer.parseInt(request.getParameter("pageNo"));
		model.addAttribute("pageNo",curPageNo);
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		List<District> districts = new ArrayList<District>();
		if(Integer.parseInt(roleType) != 0){
			String adminName = (String)request.getSession().getAttribute("adminUserName");
			School school = schoolService.getByAdmin(adminName);
			districts = districtService.getLimitDistrictsBySchool(school.getId(),(curPageNo-1)*5,20);
		}
		else{
			districts = districtService.getLimitDistricts((curPageNo-1)*5,20);
		}
		if(districts == null){
			districts = new ArrayList<District>();
		}
		int numOfItem = districts.size() > 5? 5:districts.size();
		model.addAttribute("numOfItem",numOfItem);
		int maxPage = districts.size() / 5 + curPageNo;
		if(districts.size() % 5 == 0){
			maxPage = maxPage - 1;
		}
		HashMap<Integer,String> schoolMapper = new HashMap<Integer,String>();
		for(District district:districts){
			School school = schoolService.getById(district.getSchoolId());
			schoolMapper.put(school.getId(),school.getName());
		}
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("districtInfos",districts);
		model.addAttribute("schoolMapper",schoolMapper);
		int beginPage = maxPage >= 4? maxPage - 3:1;
		model.addAttribute("beginPage",beginPage);
		model.addAttribute("page","city/district.jsp");
		return "/admin/layout";
	}

	@RequestMapping(value="/districtadd",method={GET,POST})
	public String districtAdd(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		boolean isRoot = (Integer.parseInt(roleType) == 0);
		if(Integer.parseInt(roleType) == 0){
			List<School> schools = schoolService.getAll();
			model.addAttribute("schoolInfos",schools);
		}
		else{
			String adminName = (String)request.getSession().getAttribute("adminUserName");
			School curschool = schoolService.getByAdmin(adminName);
			model.addAttribute("curschoolId",curschool.getId());
		}
		model.addAttribute("page","city/districtadd.jsp");
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		model.addAttribute("roleType",(String)request.getSession().getAttribute("roleType"));
		model.addAttribute("isRoot",isRoot);
		String get = new String("GET");
		if(request.getMethod().equals(get)){
			return "/admin/layout";
		}
		try{
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String schoolId = request.getParameter("school");
			String address = request.getParameter("address");
			if(name == null||schoolId == null||address == null||
				name.length() == 0||schoolId.length() == 0||address.length() == 0){
				model.addAttribute("error_msg","请填写所有信息");
				return "/admin/layout";
			}
			School school = schoolService.getById(Integer.parseInt(schoolId));
			if(school == null){
				model.addAttribute("error_msg","所选学校不存在");
				return "/admin/layout";
			}
			District district = new District();
			district.setName(name);
			district.setNum(1);
			district.setAddress(address);
			district.setSchoolId(Integer.parseInt(schoolId));
			district.setDeliverName("");
			district.setDeliverPhone("");
			districtService.insert(district);
			model.addAttribute("success_msg","添加成功！");
			return "/admin/layout";
		}catch(Exception e){
			//String msg = e.toString();
			//msg = msg.replace("\"","\\\"");
			//model.addAttribute("error_msg","");
			return "/admin/404";
		}
	}

	@RequestMapping(value="/districtedit", method=GET)
	public String districtEdit(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		model.addAttribute("page","city/districtedit.jsp");
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null){
				return "/admin/404";
			}
			int id = Integer.parseInt(str_id);
			District district = districtService.getById(id);
			if(district == null){
				return "/admin/404";
			}
			if(Integer.parseInt(roleType) != 0){
				String adminName = (String)request.getSession().getAttribute("adminUserName");
				School school = schoolService.getById(district.getSchoolId());
				if(!school.getAdmin().equals(adminName)){
					return "/admin/404";
				}
			}
			boolean isRoot = (Integer.parseInt(roleType) == 0);
			if(Integer.parseInt(roleType) == 0){
				List<School> schools = schoolService.getAll();
				model.addAttribute("schools",schools);
			}
			model.addAttribute("districtId",district.getId());
			model.addAttribute("districtName",district.getName());
			model.addAttribute("address",district.getAddress());
			model.addAttribute("schoolId",district.getSchoolId());
			model.addAttribute("isRoot",isRoot);
			return "/admin/layout";
		}catch(Exception e){
			return "/admin/404";
		}
	}

	@ResponseBody
	@RequestMapping(value="/savedistrict",method=POST,produces = {"application/json;charset=UTF-8"})
	public String saveDistrict(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String schoolId = request.getParameter("school");
			if(str_id == null||name == null||address == null||schoolId == null||
				str_id.length() == 0||name.length() == 0||address.length() == 0||schoolId.length() == 0){
				return "{\"code\": 1, \"msg\": \"缺少信息\"}";
			}
			int id = Integer.parseInt(str_id);
			District district = districtService.getById(id);
			if(district == null){
				return "{\"code\": 2, \"msg\": \"该仓库不存在\"}";
			}
			School school = schoolService.getById(Integer.parseInt(schoolId));
			if(school == null){
				return "{\"code\": 2, \"msg\": \"该学校不存在\"}";
			}
			if(Integer.parseInt(roleType) != 0){
				String adminName = (String)request.getSession().getAttribute("adminUserName");
				School myschool = schoolService.getById(district.getSchoolId());
				if(!myschool.getAdmin().equals(adminName)){
					return "{\"code\": 3, \"msg\": \"权限不足\"}";
				}
			}
			district.setName(name);
			district.setAddress(address);
			district.setSchoolId(Integer.parseInt(schoolId));
			districtService.update(district);
			return "{\"code\": 0,\"msg\": \"\"}";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
		}
	}

	@ResponseBody
	@RequestMapping(value="/deletedistrict",method=POST,produces = {"application/json;charset=UTF-8"})
	public String deleteDistrict(Model model, HttpServletRequest request) {
		String roleType = (String)request.getSession().getAttribute("roleType");
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null||str_id.length() == 0){
				return "{\"code\": 1, \"msg\": \"缺少id\"}";
			}
			int id = Integer.parseInt(str_id);
			District district = districtService.getById(id);
			if(district == null){
				return "{\"code\": 2, \"msg\": \"该学校不存在\"}";
			}
			if(Integer.parseInt(roleType) != 0){
				String adminName = (String)request.getSession().getAttribute("adminUserName");
				School myschool = schoolService.getById(district.getSchoolId());
				if(!myschool.getAdmin().equals(adminName)){
					return "{\"code\": 3, \"msg\": \"权限不足\"}";
				}
			}
			districtService.delete(id);
			return "{\"code\": 0,\"msg\": \"\"}";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
		}
	}

	@RequestMapping(value="/categoryList", method=GET)
	public String categoryList(Model model, HttpServletRequest request) {
		//String roleType = (String)request.getSession().getAttribute("roleType");
		int curPageNo = request.getParameter("pageNo") == null? 1:Integer.parseInt(request.getParameter("pageNo"));
		model.addAttribute("pageNo",curPageNo);
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		List<BookCategory> categories = bookCategoryService.getLimitCategories((curPageNo-1)*5,20);
		int numOfItem = categories.size() > 5? 5:categories.size();
		model.addAttribute("numOfItem",numOfItem);
		int maxPage = categories.size() / 5 + curPageNo;
		if(categories.size() % 5 == 0){
			maxPage = maxPage - 1;
		}
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("classInfos",categories);
		int beginPage = maxPage >= 4? maxPage - 3:1;
		model.addAttribute("beginPage",beginPage);
		model.addAttribute("page","book/class.jsp");
		return "/admin/layout";
	}

	@RequestMapping(value="/categoryadd",method={GET,POST})
	public String categoryAdd(@RequestParam(value = "file", required=false) MultipartFile file, Model model, HttpServletRequest request) {
		//String roleType = (String)request.getSession().getAttribute("roleType");
		model.addAttribute("page","book/classadd.jsp");
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		String get = new String("GET");
		if(request.getMethod().equals(get)){
			return "/admin/layout";
		}
		try{
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			if(name == null||name.length() == 0){
				model.addAttribute("error_msg","请填写所有信息");
				return "/admin/layout";
			}
			if(file == null||file.isEmpty()){
				model.addAttribute("error_msg","没有文件");
				return "/admin/layout";
			}
			uploadFile fileHelper = new uploadFile(request);
			String uuid =  UUID.randomUUID().toString();
			if(!fileHelper.saveFileToWeb(file,uuid)){
				model.addAttribute("error_msg","保存失败，path："+fileHelper.pathRoot+uuid);
				return "/admin/layout";
			}
			BookCategory bookCategory = new BookCategory();
			bookCategory.setTitle(name);
			bookCategory.setIconPath("/images/"+uuid);
			bookCategoryService.insert(bookCategory);
			model.addAttribute("success_msg","添加成功！");
			return "/admin/layout";
		}catch(Exception e){
			return "/admin/404";
		}
	}

	@RequestMapping(value="/categoryedit", method=GET)
	public String categoryEdit(Model model, HttpServletRequest request) {
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		model.addAttribute("page","book/classedit.jsp");
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null){
				return "/admin/404";
			}
			int id = Integer.parseInt(str_id);
			BookCategory bookCategory = bookCategoryService.getById(id);
			if(bookCategory == null){
				return "/admin/404";
			}
			model.addAttribute("categoryTitle",bookCategory.getTitle());
			model.addAttribute("id",str_id);
			return "/admin/layout";
		}catch(Exception e){
			return "/admin/404";
		}
	}

	@ResponseBody
	@RequestMapping(value="/savecategory",method=POST,produces = {"application/json;charset=UTF-8"})
	public String saveCategory(Model model, HttpServletRequest request,@RequestParam(value = "file", required = false) MultipartFile file) {
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			String name = request.getParameter("name");
			if(str_id == null||str_id.length() == 0){
				return "{\"code\": 1, \"msg\": \"缺少信息\"}";
			}
			if((name == null||name.length() == 0) && file == null){
				return "{\"code\": 1, \"msg\": \"缺少信息\"}";
			}
			int id = Integer.parseInt(str_id);
			BookCategory bookCategory = bookCategoryService.getById(id);
			if(bookCategory == null){
				return "{\"code\": 2, \"msg\": \"书类不存在\"}";
			}
			if(name != null && name.length() > 0){
				bookCategory.setTitle(name);
			}
			if(file != null){
				uploadFile fileHelper = new uploadFile(request);
				String uuid = UUID.randomUUID().toString();
				if(!fileHelper.saveFileToWeb(file,uuid)){
					return "{\"code\": 3, \"msg\": \"上传文件失败\"}";
				}
				bookCategory.setIconPath("/images/"+uuid);
			}
			bookCategoryService.update(bookCategory);
			return "{\"code\": 0,\"msg\": \"\"}";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
		}
	}

	@ResponseBody
	@RequestMapping(value="/deletecategory",method=POST,produces = {"application/json;charset=UTF-8"})
	public String deleteCategory(Model model, HttpServletRequest request) {
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null||str_id.length() == 0){
				return "{\"code\": 1, \"msg\": \"缺少id\"}";
			}
			int id = Integer.parseInt(str_id);
			BookCategory bookCategory = bookCategoryService.getById(id);
			if(bookCategory == null){
				return "{\"code\": 2, \"msg\": \"城市不存在\"}";
			}
			bookCategoryService.delete(id);
			return "{\"code\": 0,\"msg\": \"\"}";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
		}
	}

	@RequestMapping(value="/booksList", method=GET)
	public String booksList(Model model, HttpServletRequest request) {
		int curPageNo = request.getParameter("pageNo") == null? 1:Integer.parseInt(request.getParameter("pageNo"));
		model.addAttribute("pageNo",curPageNo);
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		List<Book> books = bookService.getLimitBooks((curPageNo-1)*5,20);
		int numOfItem = books.size() > 5? 5:books.size();
		model.addAttribute("numOfItem",numOfItem);
		int maxPage = books.size() / 5 + curPageNo;
		if(books.size() % 5 == 0){
			maxPage = maxPage - 1;
		}
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("bookInfos",books);
		int beginPage = maxPage >= 4? maxPage - 3:1;
		model.addAttribute("beginPage",beginPage);
		model.addAttribute("page","book/books.jsp");
		return "/admin/layout";
	}

	@RequestMapping(value="/booksadd",method={GET,POST})
	public String booksAdd(@RequestParam(value = "file", required=false) MultipartFile file, Model model, HttpServletRequest request) {
		model.addAttribute("page","book/booksadd.jsp");
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		String get = new String("GET");
		if(request.getMethod().equals(get)){
			List<BookCategory> categories = bookCategoryService.getAll();
			model.addAttribute("categoryInfos",categories);
			return "/admin/layout";
		}
		try{
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String author = request.getParameter("author");
			String press = request.getParameter("press");
			String edition = request.getParameter("edition");
			String sellingPrice_str = request.getParameter("sellingPrice");
			String rentalPrice_str = request.getParameter("rentalPrice");
			String categoryId = request.getParameter("category");
			if(name == null||author == null||press == null||edition == null||sellingPrice_str == null||rentalPrice_str == null||categoryId == null||
				name.length() == 0||author.length() == 0||press.length() == 0||edition.length() == 0||sellingPrice_str.length() == 0||
				rentalPrice_str.length() == 0||categoryId.length() == 0){
				model.addAttribute("error_msg","请填写所有信息");
				return "/admin/layout";
			}
			if(file == null||file.isEmpty()){
				model.addAttribute("error_msg","没有上传文件");
				return "/admin/layout";
			}
			uploadFile fileHelper = new uploadFile(request);
			String uuid =  UUID.randomUUID().toString();
			if(!fileHelper.saveFileToWeb(file,uuid)){
				model.addAttribute("error_msg","保存失败，path："+fileHelper.pathRoot+uuid);
				return "/admin/layout";
			}
			Book book = new Book();
			book.setTitle(name);
			book.setPress(press);
			book.setAuthor(author);
			book.setEdition(edition);
			book.setSellingPrice(Double.parseDouble(sellingPrice_str));
			book.setRentalPrice(Double.parseDouble(rentalPrice_str));
			book.setMethodId(1);
			book.setCoverPath("/images/"+uuid);
			book.setBookCategoryId(Integer.parseInt(categoryId));
			bookService.insert(book);
			model.addAttribute("success_msg","添加成功！");
			return "/admin/layout";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			model.addAttribute("error_msg",msg);
			return "/admin/layout";
			//return "/admin/404";
		}
	}

	@RequestMapping(value="/booksedit", method=GET)
	public String booksEdit(Model model, HttpServletRequest request) {
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		model.addAttribute("page","book/booksedit.jsp");
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null){
				return "/admin/404";
			}
			int id = Integer.parseInt(str_id);
			Book book = bookService.getById(id);
			if(book == null){
				return "/admin/404";
			}
			List<BookCategory> categories = bookCategoryService.getAll();
			model.addAttribute("book",book);
			model.addAttribute("categoryInfos",categories);
			return "/admin/layout";
		}catch(Exception e){
			return "/admin/404";
		}
	}

	@ResponseBody
	@RequestMapping(value="/savebooks",method=POST,produces = {"application/json;charset=UTF-8"})
	public String saveBooks(Model model, HttpServletRequest request,@RequestParam(value = "file", required = false) MultipartFile file) {
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			String name = request.getParameter("name");
			String author = request.getParameter("author");
			String press = request.getParameter("press");
			String edition = request.getParameter("edition");
			String sellingPrice_str = request.getParameter("sellingPrice");
			String rentalPrice_str = request.getParameter("rentalPrice");
			String categoryId = request.getParameter("category");
			boolean lackInfo = (name == null||author == null||press == null||edition == null||sellingPrice_str == null||rentalPrice_str == null||categoryId == null||
				name.length() == 0||author.length() == 0||press.length() == 0||edition.length() == 0||sellingPrice_str.length() == 0||
				rentalPrice_str.length() == 0||categoryId.length() == 0);
			if(str_id == null||str_id.length() == 0){
				return "{\"code\": 1, \"msg\": \"缺少信息\"}";
			}
			if(lackInfo && file == null){
				return "{\"code\": 1, \"msg\": \"缺少信息\"}";
			}
			int id = Integer.parseInt(str_id);
			Book book = bookService.getById(id);
			if(book == null){
				return "{\"code\": 2, \"msg\": \"书类不存在\"}";
			}
			if(!lackInfo){
				book.setTitle(name);
				book.setPress(press);
				book.setAuthor(author);
				book.setEdition(edition);
				book.setSellingPrice(Double.parseDouble(sellingPrice_str));
				book.setRentalPrice(Double.parseDouble(rentalPrice_str));
				book.setBookCategoryId(Integer.parseInt(categoryId));
			}
			if(file != null){
				uploadFile fileHelper = new uploadFile(request);
				String uuid = UUID.randomUUID().toString();
				if(!fileHelper.saveFileToWeb(file,uuid)){
					return "{\"code\": 3, \"msg\": \"上传文件失败\"}";
				}
				book.setCoverPath("/images/"+uuid);
			}
			bookService.update(book);
			return "{\"code\": 0,\"msg\": \"\"}";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
		}
	}

	@ResponseBody
	@RequestMapping(value="/deletebooks",method=POST,produces = {"application/json;charset=UTF-8"})
	public String deleteBooks(Model model, HttpServletRequest request) {
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null||str_id.length() == 0){
				return "{\"code\": 1, \"msg\": \"缺少id\"}";
			}
			int id = Integer.parseInt(str_id);
			Book book = bookService.getById(id);
			if(book == null){
				return "{\"code\": 2, \"msg\": \"书单不存在\"}";
			}
			bookService.delete(id);
			return "{\"code\": 0,\"msg\": \"\"}";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
		}
	}

	@RequestMapping(value="/dealedbookadd",method={GET,POST})
	public String dealedBookAdd(Model model, HttpServletRequest request) {
		model.addAttribute("page","book/bookadd.jsp");
		model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
		String roleType = (String)request.getSession().getAttribute("roleType");
		List<District> districts = null;
		School school = null;
		if(Integer.parseInt(roleType) != 0){
			String adminName = (String)request.getSession().getAttribute("adminUserName");
			school = schoolService.getByAdmin(adminName);
			districts = districtService.getDistrictBySchoolId(school.getId());
		}
		else{
			districts = districtService.getAll();
		}
		if(districts == null){
			districts = new ArrayList<District>();
		}
		model.addAttribute("districtInfos",districts);
		String get = new String("GET");
		if(request.getMethod().equals(get)){
			return "/admin/layout";
		}
		try{
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String book_id = request.getParameter("book_id");
			String district_id = request.getParameter("district");
			String user_num = request.getParameter("user");
			if(name == null||book_id == null||district_id == null||user_num == null||
				name.length() == 0||book_id.length() == 0||district_id.length() == 0||user_num.length() == 0){
				model.addAttribute("error_msg","请填写所有信息");
				return "/admin/layout";
			}
			District district = districtService.getById(Integer.parseInt(district_id));
			if(district == null||(Integer.parseInt(roleType) != 0&&district.getSchoolId() != school.getId())){
				model.addAttribute("error_msg","非法仓库");
				return "/admin/layout";
			}
			User user = userService.getUserByUserNum(user_num);
			if(user == null){
				model.addAttribute("error_msg","非法托管者");
				return "/admin/layout";
			}
			Book book = bookService.getById(Integer.parseInt(book_id));
			if(book == null){
				model.addAttribute("error_msg","找不到对应图书");
				return "/admin/layout";
			}
			Date date = new Date();
			DealedBook dealedBook = new DealedBook();
			dealedBook.setUserId(user.getId());
			dealedBook.setBookId(Integer.parseInt(book_id));
			dealedBook.setDistrictId(district.getId());
			dealedBook.setDealedNum(district_id+"-"+user_num+"-"+book_id);
			dealedBook.setSellingPrice(book.getSellingPrice());
			dealedBook.setRentalPrice(book.getRentalPrice());
			dealedBook.setDatetime(date);
			dealedBookService.insert(dealedBook);
			model.addAttribute("success_msg","添加成功！");
			return "/admin/layout";
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			model.addAttribute("error_msg",msg);
			return "/admin/layout";
			//return "/admin/404";
		}
	}

	@ResponseBody
	@RequestMapping(value="/searchbooks",method=POST,produces = {"text/html;charset=UTF-8"})
	public String searchBooks(Model model, HttpServletRequest request) {
		try{
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			if(name == null||name.length() == 0){
				return "";
			}
			List<Book> books = bookService.searchByName(name+"%");
			if(books == null){
				return "";
			}
			String res = "";
			for(Book book:books){
				res = res + "<li data-id='"+book.getId()+"'>"+book.getTitle()+"</li>";
			}
			return res;
		}catch(Exception e){
			String msg = e.toString();
			msg = msg.replace("\"","\\\"");
			return msg;
		}
	}
	
	@RequestMapping(value="/rentOrderList", method=GET)
	public String rentOrderList(Model model, HttpServletRequest request) {
		try{
			int curPageNo = request.getParameter("pageNo") == null? 1:Integer.parseInt(request.getParameter("pageNo"));
			String take_book_num = request.getParameter("take_book_num") == null? "":request.getParameter("take_book_num");
			take_book_num += "%";
			model.addAttribute("pageNo",curPageNo);
			model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
			List<RentingOrder> rentOrders = rentingOrderService.getLimitNoTookOrders((curPageNo-1)*5,20,take_book_num);
			int numOfItem = rentOrders.size() > 5? 5:rentOrders.size();
			model.addAttribute("numOfItem",numOfItem);
			int maxPage = rentOrders.size() / 5 + curPageNo;
			if(rentOrders.size() % 5 == 0){
				maxPage = maxPage - 1;
			}
			HashMap<Integer,String> bookName = new HashMap<Integer,String>();
			HashMap<Integer,Double> prices = new HashMap<Integer,Double>();
			HashMap<Integer,String> methodName = new HashMap<Integer,String>();
			HashMap<Integer,String> formatedDate = new HashMap<Integer,String>();
			for(RentingOrder order:rentOrders){
				Book book = bookService.getById(order.getBookId());
				int amount = order.getAmount();
				DeliveryMethod method = deliveryMethodService.getById(order.getDeliveryMethodId());
				int id = order.getId();
				bookName.put(id,book.getTitle());
				prices.put(id,amount * book.getRentalPrice());
				methodName.put(id,method.getName());
				formatedDate.put(id,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(order.getDatetime()));
			}
			String fullUrl = getFullUrl(request);
			model.addAttribute("preUrl",fullUrl);
			model.addAttribute("maxPage",maxPage);
			model.addAttribute("rentInfos",rentOrders);
			int beginPage = maxPage >= 4? maxPage - 3:1;
			model.addAttribute("beginPage",beginPage);
			model.addAttribute("bookName",bookName);
			model.addAttribute("prices",prices);
			model.addAttribute("methodName",methodName);
			model.addAttribute("formatedDate",formatedDate);
			model.addAttribute("redirectUrl",URLEncoder.encode(fullUrl,"UTF-8"));
			model.addAttribute("page","order/borrow.jsp");
			return "/admin/layout";
		}catch(Exception e){
			return "/admin/404";
		}
	}
	
	@RequestMapping(value="/sellOrderList", method=GET)
	public String sellOrderList(Model model, HttpServletRequest request) {
		try{
			int curPageNo = request.getParameter("pageNo") == null? 1:Integer.parseInt(request.getParameter("pageNo"));
			String take_book_num = request.getParameter("take_book_num") == null? "":request.getParameter("take_book_num");
			take_book_num += "%";
			model.addAttribute("pageNo",curPageNo);
			model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
			List<SellingOrder> sellOrders = sellingOrderService.getLimitNoTookOrders((curPageNo-1)*5,20,take_book_num);
			int numOfItem = sellOrders.size() > 5? 5:sellOrders.size();
			model.addAttribute("numOfItem",numOfItem);
			int maxPage = sellOrders.size() / 5 + curPageNo;
			if(sellOrders.size() % 5 == 0){
				maxPage = maxPage - 1;
			}
			HashMap<Integer,String> bookName = new HashMap<Integer,String>();
			HashMap<Integer,Double> prices = new HashMap<Integer,Double>();
			HashMap<Integer,String> methodName = new HashMap<Integer,String>();
			HashMap<Integer,String> formatedDate = new HashMap<Integer,String>();
			for(SellingOrder order:sellOrders){
				Book book = bookService.getById(order.getBookId());
				int amount = order.getAmount();
				DeliveryMethod method = deliveryMethodService.getById(order.getDeliveryMethodId());
				int id = order.getId();
				bookName.put(id,book.getTitle());
				prices.put(id,amount * book.getSellingPrice());
				methodName.put(id,method.getName());
				formatedDate.put(id,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(order.getDatetime()));
			}
			String fullUrl = getFullUrl(request);
			model.addAttribute("preUrl",fullUrl);
			model.addAttribute("maxPage",maxPage);
			model.addAttribute("sellInfos",sellOrders);
			int beginPage = maxPage >= 4? maxPage - 3:1;
			model.addAttribute("beginPage",beginPage);
			model.addAttribute("bookName",bookName);
			model.addAttribute("prices",prices);
			model.addAttribute("methodName",methodName);
			model.addAttribute("formatedDate",formatedDate);
			model.addAttribute("redirectUrl",URLEncoder.encode(fullUrl,"UTF-8"));
			model.addAttribute("page","order/sell.jsp");
			return "/admin/layout";
		}catch(Exception e){
			return "/admin/404";
		}
	}
	
	@RequestMapping(value="/totalSellOrderList", method={GET,POST})
	public String totalSellOrderList(Model model, HttpServletRequest request) {
		try{
			int curPageNo = request.getParameter("pageNo") == null? 1:Integer.parseInt(request.getParameter("pageNo"));
			String take_book_num = request.getParameter("take_book_num") == null? "":request.getParameter("take_book_num");
			take_book_num += "%";
			model.addAttribute("pageNo",curPageNo);
			model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
			List<SellingOrder> sellOrders = sellingOrderService.getLimitOrders((curPageNo-1)*5,20,take_book_num);
			int numOfItem = sellOrders.size() > 5? 5:sellOrders.size();
			model.addAttribute("numOfItem",numOfItem);
			int maxPage = sellOrders.size() / 5 + curPageNo;
			if(sellOrders.size() % 5 == 0){
				maxPage = maxPage - 1;
			}
			HashMap<Integer,String> bookName = new HashMap<Integer,String>();
			HashMap<Integer,Double> prices = new HashMap<Integer,Double>();
			HashMap<Integer,String> methodName = new HashMap<Integer,String>();
			HashMap<Integer,String> formatedDate = new HashMap<Integer,String>();
			for(SellingOrder order:sellOrders){
				Book book = bookService.getById(order.getBookId());
				int amount = order.getAmount();
				DeliveryMethod method = deliveryMethodService.getById(order.getDeliveryMethodId());
				int id = order.getId();
				bookName.put(id,book.getTitle());
				prices.put(id,amount * book.getSellingPrice());
				methodName.put(id,method.getName());
				formatedDate.put(id,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(order.getDatetime()));
			}
			String fullUrl = getFullUrl(request);
			model.addAttribute("preUrl",fullUrl);
			model.addAttribute("maxPage",maxPage);
			model.addAttribute("sellInfos",sellOrders);
			int beginPage = maxPage >= 4? maxPage - 3:1;
			model.addAttribute("beginPage",beginPage);
			model.addAttribute("bookName",bookName);
			model.addAttribute("prices",prices);
			model.addAttribute("methodName",methodName);
			model.addAttribute("formatedDate",formatedDate);
			model.addAttribute("redirectUrl",URLEncoder.encode(fullUrl,"UTF-8"));
			model.addAttribute("page","order/allorder.jsp");
			return "/admin/layout";
		}catch(Exception e){
			return "/admin/404";
		}
	}
	
	@RequestMapping(value="/totalRentOrderList", method=GET)
	public String totalRentOrderList(Model model, HttpServletRequest request) {
		try{
			int curPageNo = request.getParameter("pageNo") == null? 1:Integer.parseInt(request.getParameter("pageNo"));
			String take_book_num = request.getParameter("take_book_num") == null? "":request.getParameter("take_book_num");
			take_book_num += "%";
			model.addAttribute("pageNo",curPageNo);
			model.addAttribute("districtAddrStr",(String)request.getSession().getAttribute("districtAddr"));
			List<RentingOrder> rentOrders = rentingOrderService.getLimitOrders((curPageNo-1)*5,20,take_book_num);
			int numOfItem = rentOrders.size() > 5? 5:rentOrders.size();
			model.addAttribute("numOfItem",numOfItem);
			int maxPage = rentOrders.size() / 5 + curPageNo;
			if(rentOrders.size() % 5 == 0){
				maxPage = maxPage - 1;
			}
			HashMap<Integer,String> bookName = new HashMap<Integer,String>();
			HashMap<Integer,Double> prices = new HashMap<Integer,Double>();
			HashMap<Integer,String> methodName = new HashMap<Integer,String>();
			HashMap<Integer,String> formatedDate = new HashMap<Integer,String>();
			for(RentingOrder order:rentOrders){
				Book book = bookService.getById(order.getBookId());
				int amount = order.getAmount();
				DeliveryMethod method = deliveryMethodService.getById(order.getDeliveryMethodId());
				int id = order.getId();
				bookName.put(id,book.getTitle());
				prices.put(id,amount * book.getRentalPrice());
				methodName.put(id,method.getName());
				formatedDate.put(id,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(order.getDatetime()));
			}
			String fullUrl = getFullUrl(request);
			model.addAttribute("preUrl",fullUrl);
			model.addAttribute("maxPage",maxPage);
			model.addAttribute("rentInfos",rentOrders);
			int beginPage = maxPage >= 4? maxPage - 3:1;
			model.addAttribute("beginPage",beginPage);
			model.addAttribute("bookName",bookName);
			model.addAttribute("prices",prices);
			model.addAttribute("methodName",methodName);
			model.addAttribute("formatedDate",formatedDate);
			model.addAttribute("redirectUrl",URLEncoder.encode(fullUrl,"UTF-8"));
			model.addAttribute("page","order/allorder_borrow.jsp");
			return "/admin/layout";
		}catch(Exception e){
			return "/admin/404";
		}
	}

	@RequestMapping(value="/rentOrderDone",method={GET,POST})
	public String rentOrderDone(Model model, HttpServletRequest request) {
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null||str_id.length() == 0){
				return "/admin/404";
			}
			String url = request.getParameter("redirectUrl");
			if(url == null||url.length() == 0){
				return "/admin/404";
			}
			int id = Integer.parseInt(str_id);
			RentingOrder order = rentingOrderService.getById(id);
			if(order == null){
				return "/admin/404";
			}
			order.setTook(1);
			rentingOrderService.update(order);
			String real_url = URLDecoder.decode(url,"UTF-8");
			return "redirect:"+real_url;
		}catch(Exception e){
			//String msg = e.toString();
			//msg = msg.replace("\"","\\\"");
			//return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
			return "/admin/404";
		}
	}

	@RequestMapping(value="/sellOrderDone",method={GET,POST})
	public String sellOrderDone(Model model, HttpServletRequest request) {
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null||str_id.length() == 0){
				return "/admin/404";
			}
			String url = request.getParameter("redirectUrl");
			if(url == null||url.length() == 0){
				return "/admin/404";
			}
			int id = Integer.parseInt(str_id);
			SellingOrder order = sellingOrderService.getById(id);
			if(order == null){
				return "/admin/404";
			}
			order.setTook(1);
			sellingOrderService.update(order);
			String real_url = URLDecoder.decode(url,"UTF-8");
			return "redirect:"+real_url;
		}catch(Exception e){
			//String msg = e.toString();
			//msg = msg.replace("\"","\\\"");
			//return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
			return "/admin/404";
		}
	}

	@RequestMapping(value="/deleteSellOrder",method={GET,POST})
	public String deleteSellOrder(Model model, HttpServletRequest request) {
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null||str_id.length() == 0){
				return "/admin/404";
			}
			String url = request.getParameter("redirectUrl");
			if(url == null||url.length() == 0){
				return "/admin/404";
			}
			int id = Integer.parseInt(str_id);
			SellingOrder order = sellingOrderService.getById(id);
			if(order == null){
				return "/admin/404";
			}
			sellingOrderService.delete(id);
			String real_url = URLDecoder.decode(url,"UTF-8");
			return "redirect:"+real_url;
		}catch(Exception e){
			//String msg = e.toString();
			//msg = msg.replace("\"","\\\"");
			//return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
			return "/admin/404";
		}
	}

	@RequestMapping(value="/deleteRentOrder",method={GET,POST})
	public String deleteRentOrder(Model model, HttpServletRequest request) {
		try{
			request.setCharacterEncoding("UTF-8");
			String str_id = request.getParameter("id");
			if(str_id == null||str_id.length() == 0){
				return "/admin/404";
			}
			String url = request.getParameter("redirectUrl");
			if(url == null||url.length() == 0){
				return "/admin/404";
			}
			int id = Integer.parseInt(str_id);
			RentingOrder order = rentingOrderService.getById(id);
			if(order == null){
				return "/admin/404";
			}
			rentingOrderService.delete(id);
			String real_url = URLDecoder.decode(url,"UTF-8");
			return "redirect:"+real_url;
		}catch(Exception e){
			//String msg = e.toString();
			//msg = msg.replace("\"","\\\"");
			//return "{\"code\": 4,\"msg\": \"" + msg + "\"}";
			return "/admin/404";
		}
	}


}
