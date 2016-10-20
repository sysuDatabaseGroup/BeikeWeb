package com.databasegroup.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.databasegroup.dao.IAnnounDao;
import com.databasegroup.dao.IBookClassDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IClassDao;
import com.databasegroup.model.BookClass;
import com.databasegroup.model.Class;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestBookClassDao {
	
	@Autowired
	private IBookClassDao bookClassDao;
	
	@Test
	public void bookClassDaoShouldNotBeNull() {
		assertNotNull(bookClassDao);
		
		BookClass bookClass = bookClassDao.getById(2);
		bookClass.setAuthor("update");
		bookClassDao.update(bookClass);
		
//		BookClass bookClass = new BookClass();
//		bookClass.setClassID(2);
//		bookClass.setAuthor("author");
//		bookClass.setBookClassImg("BookClassImg");
//		bookClass.setBookClassName("BookClassName");
//		bookClass.setBorrowPrice(233);
//		bookClass.setCompany("Company");
//		bookClass.setMethodID(2);
//		bookClass.setSellPrice(233);
//		bookClass.setVersion("version");
//		
//		bookClassDao.insert(bookClass);
//		
//		bookClass = bookClassDao.getById(1);
//		
//		System.out.println(bookClass);
//		
//		System.out.println(bookClassDao.getAll());
//		
//		bookClassDao.delete(1);
//		
//		System.out.println(bookClassDao.getAll());
//		
//		bookClassDao.insert(bookClass);
	}
}
