package com.databasegroup.test.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.databasegroup.controller.fortest.HelloController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:servlet-context.xml")
public class TestHelloController {
	
	@Autowired
	private HelloController helloController;
	
	@Test
	public void helloControllerShouldNotBeNull() {
		assertNotNull(helloController);
	}
}
