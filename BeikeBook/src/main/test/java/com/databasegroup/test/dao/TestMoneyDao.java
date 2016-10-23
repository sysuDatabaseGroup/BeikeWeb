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
import com.databasegroup.dao.IMoneyDao;
import com.databasegroup.model.Book;
import com.databasegroup.model.BookClass;
import com.databasegroup.model.Class;
import com.databasegroup.model.Money;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestMoneyDao {
	
	@Autowired
	private IMoneyDao moneyDao;
	
	@Test
	public void moneyDaoShouldNotBeNull() {
		assertNotNull(moneyDao);
		
		Money money = moneyDao.getById(2);
		money.setAlipayAccount("update");
		moneyDao.update(money);
		
//		Money money = new Money();
//		money.setAlipayAccount("alipayaccount");
//		money.setAlipayName("AlipayName");
//		money.setMoneyNum(233);
//		money.setPhone("132324234");
//		
//		
//		moneyDao.insert(money);
//		
//		money = moneyDao.getById(1);
//		
//		System.out.println(money);
//		
//		System.out.println(moneyDao.getAll());
//		
//		moneyDao.delete(1);
//		
//		System.out.println(moneyDao.getAll());
//		
//		moneyDao.insert(money);
	}
}
