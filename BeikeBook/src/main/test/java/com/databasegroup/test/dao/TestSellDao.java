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
import com.databasegroup.dao.ISellDao;
import com.databasegroup.model.Book;
import com.databasegroup.model.BookClass;
import com.databasegroup.model.Class;
import com.databasegroup.model.Sell;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestSellDao {
	
	@Autowired
	private ISellDao sellDao;
	
	@Test
	public void sellDaoShouldNotBeNull() {
		assertNotNull(sellDao);
		
		Sell sell = sellDao.getById(2);
		sell.setTakeBookNum("update");
		sellDao.update(sell);
		
//		Sell sell = new Sell();
//		sell.setBookID(2);
//		sell.setDatetime(new Date());
//		sell.setIsMoney(1);
//		sell.setMethodID(2);
//		sell.setNum(2);
//		sell.setTakeBookNum("TakeBookNum");
//		sell.setUserID(2);
//		
//		
//		sellDao.insert(sell);
//		
//		sell = sellDao.getById(1);
//		
//		System.out.println(sell);
//		
//		System.out.println(sellDao.getAll());
//		
//		sellDao.delete(1);
//		
//		System.out.println(sellDao.getAll());
//		
//		sellDao.insert(sell);
	}
}
