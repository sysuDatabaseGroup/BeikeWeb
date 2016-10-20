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
		
		City city = cityDao.getById(1);
		city.setCityName("HongKong");
		city.setCityNum("HK");
		
		cityDao.update(city);
//		
//		City city = cityDao.getById(1);
//		System.out.println(city);
		
//		City city = new City();
//		city.setCityName("Beijing");
//		city.setCityNum("BJ");
//		cityDao.insert(city);
//		city.setCityName("Shanghai");
//		city.setCityNum("SH");
//		cityDao.insert(city);
		
//		List<City> cities = cityDao.getAll();
//		for (City city : cities) {
//			System.out.println(city.getCityName() + ' ' + city.getCityNum());
//		}
		
//		cityDao.delete(2);
//		cityDao.delete(3);
	}
}
