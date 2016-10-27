package com.databasegroup.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.databasegroup.dao.IAnnounDao;
import com.databasegroup.dao.IBookDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IBookCategoryDao;
import com.databasegroup.model.Book;
import com.databasegroup.model.BookCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestBookDao {
	
	@Autowired
	private IBookDao bookDao;
	
	@Test
	public void bookClassDaoShouldNotBeNull() {
		assertNotNull(bookDao);
		
		Book book = bookDao.getById(2);
		book.setAuthor("update");
		bookDao.update(book);
		System.out.println(book);
		
//		Book book = new Book();
//		book.setBookCategoryId(2);
//		book.setAuthor("author");
//		book.setCoverPath("BookClassImg");
//		book.setTitle("BookClassName");
//		book.setRentalPrice(233);
//		book.setPress("Company");
//		book.setDeliveryMethodId(2);
//		book.setSellingPrice(233);
//		book.setEdition("version");
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
