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
import com.databasegroup.dao.ISellingOrderDao;
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.Book;
import com.databasegroup.model.BookCategory;
import com.databasegroup.model.SellingOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestSellingOrderDao {
	
	@Autowired
	private ISellingOrderDao sellingOrderDao;
	
	@Test
	public void sellDaoShouldNotBeNull() {
		assertNotNull(sellingOrderDao);
		
		SellingOrder sell = sellingOrderDao.getById(2);
		sell.setTakingBookNum("update");
		sellingOrderDao.update(sell);
		
//		SellingOrder sell = new SellingOrder();
//		sell.setDealedBookId(2);
//		sell.setDatetime(new Date());
//		sell.setPayed(1);
//		sell.setDeliveryMethodId(2);
//		sell.setNum(2);
//		sell.setTakingBookNum("TakeBookNum");
//		sell.setUserId(2);
//		
//		
//		sellingOrderDao.insert(sell);
//		
//		sell = sellingOrderDao.getById(1);
//		
//		System.out.println(sell);
//		
//		System.out.println(sellingOrderDao.getAll());
//		
//		sellingOrderDao.delete(1);
//		
//		System.out.println(sellingOrderDao.getAll());
//		
//		sellingOrderDao.insert(sell);
	}
}
