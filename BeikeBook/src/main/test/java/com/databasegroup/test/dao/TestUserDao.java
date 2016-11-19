package com.databasegroup.test.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.databasegroup.dao.IAnnounDao;
import com.databasegroup.dao.IBookDao;
import com.databasegroup.dao.IDealedBookDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IBookCategoryDao;
import com.databasegroup.dao.IUserDao;
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.Book;
import com.databasegroup.model.BookCategory;
import com.databasegroup.model.User;
import com.databasegroup.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:servlet-context.xml"})
public class TestUserDao {
	
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IUserService userSerivce;
	
	@Test
	public void userDaoShouldNotBeNull() {
		assertNotNull(userDao);
		
		
//		User user = userDao.getById(1);
//		user.setWithdrawalAmount(0);
//		userSerivce.update(user);
//		System.out.println(user);
//		
//		new Thread() {
//			@Override
//			public void run() {
//				int k = 3000;
//				while (k-- > 0) {
//					userSerivce.addEncashingAmount(user.getId(), 
//							1);
//				}
//			}
//			
//		}.start();
//
//		int k = 5000;
//		while (k-- > 0) {
//			userSerivce.addEncashingAmount(user.getId(), 
//					1);
//		}
//		
//		System.out.println(user);
		
//		User user = userDao.authUser("usernum", "password");
//		System.out.println(user);
		
//		User user = userDao.getById(2);
//		user.setWxName("update");
//		userDao.update(user);
//		System.out.println(user);
		
		User user = new User();
		user.setCityId(1);
		user.setDorm("Dorm");
		user.setSchoolId(1);
		user.setUserNum("UserNum");
		user.setPassword("Password");
		user.setWxName("wx_name");
		user.setWxPhoto("wx_photo");
		
		userSerivce.insert(user);
//		
//		user = userDao.getById(1);
//		
//		System.out.println(user);
//		
//		System.out.println(userDao.getAll());
//		
//		userDao.delete(1);
//		
//		System.out.println(userDao.getAll());
//		
//		userDao.insert(user);
	}
}
