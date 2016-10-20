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
import com.databasegroup.model.Book;
import com.databasegroup.model.BookClass;
import com.databasegroup.model.Class;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestBookDao {
	
	@Autowired
	private IBookDao bookDao;
	
	@Test
	public void bookDaoShouldNotBeNull() {
		assertNotNull(bookDao);
		
		Book book = bookDao.getById(2);
		book.setBookNum("update");
		bookDao.update(book);
		
//		Book book = new Book();
//		book.setBookClassID(2);
//		book.setBookNum("BookNum");
//		book.setBorrowPrice(233);
//		book.setDatetime(new Date());
//		book.setDistrictID(2);
//		book.setIsSell(0);
//		book.setSellPrice(233);
//		book.setUserID(2);
//		
//		bookDao.insert(book);
//		
//		book = bookDao.getById(1);
//		
//		System.out.println(book);
//		
//		System.out.println(bookDao.getAll());
//		
//		bookDao.delete(1);
//		
//		System.out.println(bookDao.getAll());
//		
//		bookDao.insert(book);
	}
}
