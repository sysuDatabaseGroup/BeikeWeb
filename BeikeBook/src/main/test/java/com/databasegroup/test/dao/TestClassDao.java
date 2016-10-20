package com.databasegroup.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.databasegroup.dao.IAnnounDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IClassDao;
import com.databasegroup.model.Class;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestClassDao {
	
	@Autowired
	private IClassDao classDao;
	
	@Test
	public void classDaoShouldNotBeNull() {
		assertNotNull(classDao);
		
		Class mclass = classDao.getById(2);
		mclass.setClassName("update");
		classDao.update(mclass);
		
//		Class mclass = new Class();
//		mclass.setClassImg("C:\\");
//		mclass.setClassName("This ");
//		
//		classDao.insert(mclass);
//		
//		mclass = classDao.getById(1);
//		System.out.println(mclass);
//		
//		System.out.println(classDao.getAll());
//		
//		classDao.delete(1);
//		
//		System.out.println(classDao.getAll());
//		
//		classDao.insert(mclass);
	}
}
