package com.databasegroup.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.databasegroup.dao.ICityDao;
import com.databasegroup.model.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestCityDao {
	
	@Autowired
	private ICityDao cityDao;
	
	@Test
	public void cityDaoShouldNotBeNull() {
		assertNotNull(cityDao);
		
//		City city = cityDao.getById(2);
//		city.setName("HongKong");
//		city.setNum("HK");
//		
//		cityDao.update(city);
//		
//		City city = cityDao.getById(1);
//		System.out.println(city);
		
		City city = new City();
		city.setName("Beijing");
		city.setNum("BJ");
		cityDao.insert(city);

		System.out.println(cityDao.getById(1));
		System.out.println(cityDao.getAll());
		
		cityDao.delete(1);
		
		System.out.println(cityDao.getAll());
		
		cityDao.insert(city);
		
	}
}
