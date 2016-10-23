package com.databasegroup.test.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.databasegroup.service.ICityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestCityServiceImpl {
	
	@Autowired
	private ICityService cityService;
	
	@Test
	public void cityServiceShouldNotBeNull() {
		assertNotNull(cityService);
	}
}
