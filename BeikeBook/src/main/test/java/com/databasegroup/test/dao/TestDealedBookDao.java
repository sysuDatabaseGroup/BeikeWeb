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
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.Book;
import com.databasegroup.model.BookCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestDealedBookDao {
	
	@Autowired
	private IDealedBookDao bookDao;
	
	@Test
	public void bookDaoShouldNotBeNull() {
		assertNotNull(bookDao);
		
		DealedBook book = bookDao.getById(2);
		book.setDealedNum("update");
		bookDao.update(book);
		System.out.println(book);
		
//		DealedBook book = new DealedBook();
//		book.setBookId(2);
//		book.setDealedNum("BookNum");
//		book.setRentalPrice(233);
//		book.setDatetime(new Date());
//		book.setDistrictId(2);
//		book.setSelled(0);
//		book.setSellingPrice(233);
//		book.setUserId(2);
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
