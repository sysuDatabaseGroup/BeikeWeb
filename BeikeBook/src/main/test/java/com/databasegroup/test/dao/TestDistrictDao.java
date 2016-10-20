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
import com.databasegroup.dao.IDistrictDao;
import com.databasegroup.model.BookClass;
import com.databasegroup.model.Borrow;
import com.databasegroup.model.Class;
import com.databasegroup.model.District;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestDistrictDao {
	
	@Autowired
	private IDistrictDao districtDao;
	
	@Test
	public void districtDaoShouldNotBeNull() {
		assertNotNull(districtDao);
		
		District district = districtDao.getById(2);
		district.setAddress("update");
		districtDao.update(district);
		
//		District district = new District();
//		district.setAddress("Address");
//		district.setDeliverName("Deliv");
//		district.setDeliverPhone("Deliv");
//		district.setDistrictName("Distri");
//		district.setDistrictNum(2);
//		district.setSchoolID(2);
//		
//		
//		districtDao.insert(district);
//		
//		district = districtDao.getById(1);
//		
//		System.out.println(district);
//		
//		System.out.println(districtDao.getAll());
//		
//		districtDao.delete(1);
//		
//		System.out.println(districtDao.getAll());
//		
//		districtDao.insert(district);
	}
}
