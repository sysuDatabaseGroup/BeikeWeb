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
import com.databasegroup.dao.IBookDao;
import com.databasegroup.dao.IRentingOrderDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IBookCategoryDao;
import com.databasegroup.dao.IDistrictDao;
import com.databasegroup.model.Book;
import com.databasegroup.model.RentingOrder;
import com.databasegroup.model.BookCategory;
import com.databasegroup.model.District;
import com.databasegroup.model.DistrictStoredSituation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestDistrictDao {
	
	@Autowired
	private IDistrictDao districtDao;
	
	@Test
	public void districtDaoShouldNotBeNull() {
		assertNotNull(districtDao);
		
		List<DistrictStoredSituation> list = 
				districtDao.getSituationByBookId(2);
		System.out.println(list);
		
//		District district = districtDao.getById(2);
//		district.setAddress("update");
//		districtDao.update(district);
		
//		District district = new District();
//		district.setAddress("Address");
//		district.setDeliverName("Deliv");
//		district.setDeliverPhone("Deliv");
//		district.setName("Distri");
//		district.setNum(2);
//		district.setSchoolId(3);
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
