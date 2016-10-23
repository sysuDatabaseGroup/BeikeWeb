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
import com.databasegroup.dao.IBookClassDao;
import com.databasegroup.dao.IBookDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IClassDao;
import com.databasegroup.dao.IUserDao;
import com.databasegroup.model.Book;
import com.databasegroup.model.BookClass;
import com.databasegroup.model.Class;
import com.databasegroup.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestUserDao {
	
	@Autowired
	private IUserDao userDao;
	
	@Test
	public void userDaoShouldNotBeNull() {
		assertNotNull(userDao);
		
		User user = userDao.getById(2);
		user.setWx_name("update");
		userDao.update(user);
//		
//		User user = new User();
//		user.setCityID(1);
//		user.setDorm("Dorm");
//		user.setSchoolID(2);
//		user.setUserNum("UserNum");
//		user.setWx_name("wx_name");
//		user.setWx_photo("wx_photo");
//		
////		
//		userDao.insert(user);
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
