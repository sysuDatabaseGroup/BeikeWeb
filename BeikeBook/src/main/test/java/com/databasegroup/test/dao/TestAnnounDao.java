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
import com.databasegroup.model.Announ;
import com.databasegroup.model.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestAnnounDao {
	
	@Autowired
	private IAnnounDao announDao;
	
	@Test
	public void announDaoShouldNotBeNull() {
		assertNotNull(announDao);
		
		Announ announ = announDao.getById(2);
		announ.setAnnounContent("Update");
		announDao.update(announ);
		
//		Announ announ = new Announ();
//		announ.setAnnounContent("This is Announ");
//
//		announDao.insert(announ);
//		
//		announ = announDao.getById(1);
//		
//		System.out.println(announ);
//		
//		System.out.println(announDao.getAll());
//		
//		announDao.delete(1);
//		
//		System.out.println(announDao.getAll());
//		
//		announDao.insert(announ);
	}
}
