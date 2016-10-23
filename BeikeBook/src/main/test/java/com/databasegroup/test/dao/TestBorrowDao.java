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
import com.databasegroup.dao.IBorrowDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IClassDao;
import com.databasegroup.model.BookClass;
import com.databasegroup.model.Borrow;
import com.databasegroup.model.Class;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestBorrowDao {
	
	@Autowired
	private IBorrowDao borrowDao;
	
	@Test
	public void borrowDaoShouldNotBeNull() {
		assertNotNull(borrowDao);
		
		Borrow borrow = borrowDao.getById(2);
		borrow.setTakeBookNum("update");
		borrowDao.update(borrow);
		
//		Borrow borrow = new Borrow();
//		borrow.setDatetime(new Date());
//		borrow.setIsBack(1);
//		borrow.setIsTake(1);
//		borrow.setMethodID(2);
//		borrow.setNum(2);
//		borrow.setTakeBookNum("TakeBookNum");
//		borrow.setUserID(2);
//		
//		
//		borrowDao.insert(borrow);
//		
//		borrow = borrowDao.getById(1);
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
