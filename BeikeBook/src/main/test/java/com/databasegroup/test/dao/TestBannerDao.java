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
import com.databasegroup.dao.IBannerDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.model.Announ;
import com.databasegroup.model.Banner;
import com.databasegroup.model.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestBannerDao {
	
	@Autowired
	private IBannerDao bannerDao;
	
	@Test
	public void bannerDaoShouldNotBeNull() {
		assertNotNull(bannerDao);
		
		Banner banner = bannerDao.getById(2);
		banner.setTitle("update110");
		bannerDao.update(banner);
		
//		Banner banner = new Banner();
//		
//		banner.setPicPath("c:\\");
//		banner.setTitle("banner 1");
//		banner.setDatetime(new Date());
//		banner.setLink("www.hao123.com");
//		banner.setPrior(3);
//		
//		bannerDao.insert(banner);
//		
//		banner = bannerDao.getById(1);
//		
//		System.out.println(banner);
//		
//		System.out.println(bannerDao.getAll());
//		
//		bannerDao.delete(1);
//		
//		System.out.println(bannerDao.getAll());
//		
//		bannerDao.insert(banner);
	}
}
