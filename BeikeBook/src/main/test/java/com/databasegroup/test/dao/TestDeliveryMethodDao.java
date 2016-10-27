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
import com.databasegroup.dao.IDeliveryMethodDao;
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.Book;
import com.databasegroup.model.BookCategory;
import com.databasegroup.model.DeliveryMethod;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestDeliveryMethodDao {
	
	@Autowired
	private IDeliveryMethodDao deliveryMethodDao;
	
	@Test
	public void methodDaoShouldNotBeNull() {
		assertNotNull(deliveryMethodDao);
		
		DeliveryMethod method = deliveryMethodDao.getById(2);
		method.setName("update");
		deliveryMethodDao.update(method);
		System.out.println(method);
//		
//		DeliveryMethod method = new DeliveryMethod();
//		method.setName("MethodName");
//		method.setPrice(233);
//		
//		deliveryMethodDao.insert(method);
//		
//		method = deliveryMethodDao.getById(1);
//		
//		System.out.println(method);
//		
//		System.out.println(deliveryMethodDao.getAll());
//		
//		deliveryMethodDao.delete(1);
//		
//		System.out.println(deliveryMethodDao.getAll());
//		
//		deliveryMethodDao.insert(method);
	}
}
