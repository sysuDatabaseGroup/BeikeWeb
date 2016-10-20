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
import com.databasegroup.dao.IMethodDao;
import com.databasegroup.model.Book;
import com.databasegroup.model.BookClass;
import com.databasegroup.model.Class;
import com.databasegroup.model.Method;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestMethodDao {
	
	@Autowired
	private IMethodDao methodDao;
	
	@Test
	public void methodDaoShouldNotBeNull() {
		assertNotNull(methodDao);
		
		Method method = methodDao.getById(2);
		method.setMethodName("update");
		methodDao.update(method);
		
//		Method method = new Method();
//		method.setMethodName("MethodName");
//		method.setPrice(233);
//		
//		methodDao.insert(method);
//		
//		method = methodDao.getById(1);
//		
//		System.out.println(method);
//		
//		System.out.println(methodDao.getAll());
//		
//		methodDao.delete(1);
//		
//		System.out.println(methodDao.getAll());
//		
//		methodDao.insert(method);
	}
}
