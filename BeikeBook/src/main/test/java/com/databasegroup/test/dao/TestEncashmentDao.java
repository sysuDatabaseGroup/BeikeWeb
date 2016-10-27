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
import com.databasegroup.dao.IEncashmentDao;
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.Book;
import com.databasegroup.model.BookCategory;
import com.databasegroup.model.Encashment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestEncashmentDao {
	
	@Autowired
	private IEncashmentDao encashmentDao;
	
	@Test
	public void moneyDaoShouldNotBeNull() {
		assertNotNull(encashmentDao);
		
		Encashment money = encashmentDao.getById(2);
		money.setAlipayAccount("update");
		encashmentDao.update(money);
		System.out.println(money);
		
//		Encashment money = new Encashment();
//		money.setAlipayAccount("alipayaccount");
//		money.setAlipayName("AlipayName");
//		money.setEncashingAmount(233);
//		money.setPhone("132324234");
//		
//		
//		encashmentDao.insert(money);
//		
//		money = encashmentDao.getById(1);
//		
//		System.out.println(money);
//		
//		System.out.println(encashmentDao.getAll());
//		
//		encashmentDao.delete(1);
//		
//		System.out.println(encashmentDao.getAll());
//		
//		encashmentDao.insert(money);
	}
}
