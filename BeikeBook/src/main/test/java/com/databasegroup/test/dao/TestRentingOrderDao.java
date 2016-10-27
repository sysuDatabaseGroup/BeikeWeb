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
import com.databasegroup.dao.IRentingOrderDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IBookCategoryDao;
import com.databasegroup.model.Book;
import com.databasegroup.model.RentingOrder;
import com.databasegroup.model.BookCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestRentingOrderDao {
	
	@Autowired
	private IRentingOrderDao borrowDao;
	
	@Test
	public void borrowDaoShouldNotBeNull() {
		assertNotNull(borrowDao);
		
		RentingOrder borrow = borrowDao.getById(2);
		borrow.setTakingBookNum("update");
		borrowDao.update(borrow);
		System.out.print(borrow);
		
//		RentingOrder borrow = new RentingOrder();
//		borrow.setDatetime(new Date());
//		borrow.setReturned(1);
//		borrow.setTook(1);
//		borrow.setDeliveryMethodId(2);
//		borrow.setAmount(2);
//		borrow.setTakingBookNum("TakeBookNum");
//		borrow.setUserId(2);
//		borrow.setDealedBookId(2);
//		
//		
//		borrowDao.insert(borrow);
//		
//		borrow = borrowDao.getById(2);
//		
//		System.out.println(borrow);
//		
//		System.out.println(borrowDao.getAll());
//		
//		borrowDao.delete(1);
//		
//		System.out.println(borrowDao.getAll());
//		
//		borrowDao.insert(borrow);
	}
}
