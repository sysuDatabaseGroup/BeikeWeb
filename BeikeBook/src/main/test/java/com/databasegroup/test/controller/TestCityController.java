package com.databasegroup.test.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.databasegroup.controller.CityController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:servlet-context.xml", "classpath:spring-mybatis.xml"})
public class TestCityController {
	
	@Autowired
	private CityController cityController;
	
	@Test
	public void cityControllerShouldNotBeNull() {
		assertNotNull(cityController);
	}
}
