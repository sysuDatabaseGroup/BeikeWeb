package com.databasegroup.test.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
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
import com.databasegroup.service.ISellingOrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestSellingOrderDao {
	
	@Autowired
	private ISellingOrderDao sellingOrderDao;
	
	@Autowired
	private ISellingOrderService sellingOrderService;
	
	@Autowired
	private IDealedBookDao dealedBookDao;
	
	@Test
	public void sellDaoShouldNotBeNull() {
		assertNotNull(sellingOrderDao);
		
		DealedBook dealedBook = new DealedBook();
		dealedBook.setBookId(1);
		dealedBook.setDealedNum("DealedNum");
		dealedBook.setSellingPrice(6);
		dealedBook.setRentalPrice(12);
		dealedBook.setDistrictId(1);
		dealedBook.setUserId(1);
		dealedBook.setDatetime(new Date());
		
		for (int i = 1; i <= 2000; i++)
			dealedBookDao.insert(dealedBook);
		
		SellingOrder order = new SellingOrder();
		order.setUserId(2);
		order.setDeliveryMethodId(1);  //
		order.setBookId(dealedBook.getBookId());  //
		order.setAmount(1);
		order.setDatetime(new Date());
		order.setPayed(1);
		// 取书号：学校编号+日期+待售书的ID
		order.setTakingBookNum( "" +
				"SYSU" +
				new SimpleDateFormat("yyyyMMdd").format(new Date()) +
				String.format("%05d", dealedBook.getId())
					);
		long time = System.currentTimeMillis();
		new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 200; i++) {
					sellingOrderService.insertOrder(order);
				}
			}
		}.start();
		
		for (int i = 1; i <= 200; i++) {
			sellingOrderService.insertOrder(order);
		}
		
		System.out.println(System.currentTimeMillis() - time);
		
//		SellingOrder sell = sellingOrderDao.getById(2);
//		sell.setTakingBookNum("update");
//		sellingOrderDao.update(sell);
		
//		System.out.println(sellingOrderDao.getById(1));
		
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
