package com.databasegroup.test.config;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.databasegroup.config.SecurityConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:servlet-context.xml", "classpath:spring-mybatis.xml"})
public class TestSecurityConfiguration {
	
	@Autowired
	private SecurityConfiguration securityConfiguration;
	
	@Test
	public void securityConfigurationSholdNotBeNull() {
		assertNotNull(securityConfiguration);
	}
}
