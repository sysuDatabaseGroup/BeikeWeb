package com.databasegroup.test.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.databasegroup.service.IBookService;
import com.databasegroup.service.ICityService;
import com.databasegroup.service.IDealedBookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:servlet-context.xml"})
public class SpringTestCase {
	
	@Autowired
	private IDealedBookService dealedBookService;
	
	@Test
	public void bookServiceShouldNotBeNull()   {
		assertNotNull(dealedBookService);
		long time = System.currentTimeMillis();
		System.out.println(dealedBookService.getNoSelledAndNoRentedBookByBookId(1));
		long time2 = System.currentTimeMillis();
		System.out.println("第一次调用时间： " + (time2-time));
		System.out.println(dealedBookService.getNoSelledAndNoRentedBookByBookId(1));
		long time3 = System.currentTimeMillis();
		System.out.println("第二次调用时间： " + (time3-time2));
	}
}
