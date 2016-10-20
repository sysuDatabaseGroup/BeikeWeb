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
import com.databasegroup.dao.IBookDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IClassDao;
import com.databasegroup.dao.ISchoolDao;
import com.databasegroup.model.Book;
import com.databasegroup.model.BookClass;
import com.databasegroup.model.Class;
import com.databasegroup.model.School;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestSchoolDao {
	
	@Autowired
	private ISchoolDao schoolDao;
	
	@Test
	public void schoolDaoShouldNotBeNull() {
		assertNotNull(schoolDao);
		
		School school = schoolDao.getById(2);
		school.setSchoolName("update");
		schoolDao.update(school);
		
//		School school = new School();
//		
//		school.setSchoolAdmin("SchoolAdmin");
//		school.setCityID(1);
//		school.setSchoolName("SchoolName");
//		school.setSchoolNum("SchoolNum");
//		school.setSchoolPassword("SchoolPass");
////		
//		schoolDao.insert(school);
//		
//		System.out.println(schoolDao.getById(1));
//		
//		school = schoolDao.getById(1);
//		
//		System.out.println(school);
//		
//		System.out.println(schoolDao.getAll());
//		
//		schoolDao.delete(1);
//		
//		System.out.println(schoolDao.getAll());
//		
//		schoolDao.insert(school);
	}
}
