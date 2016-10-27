package com.databasegroup.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.databasegroup.dao.IAnnounDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IBookCategoryDao;
import com.databasegroup.model.BookCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestBookCategoryDao {
	
	@Autowired
	private IBookCategoryDao bookCategoryDao;
	
	@Test
	public void classDaoShouldNotBeNull() {
		assertNotNull(bookCategoryDao);
		
		BookCategory bookCategory = bookCategoryDao.getById(2);
		bookCategory.setTitle("update");
		bookCategoryDao.update(bookCategory);
		System.out.println(bookCategoryDao.getById(2));
		
//		BookCategory bookCategory = new BookCategory();
//		bookCategory.setIconPath("C:\\");
//		bookCategory.setTitle("This ");
//		
//		bookCategoryDao.insert(bookCategory);
//		
//		bookCategory = bookCategoryDao.getById(1);
//		System.out.println(bookCategory);
//		
//		System.out.println(bookCategoryDao.getAll());
//		
//		bookCategoryDao.delete(1);
//		
//		System.out.println(bookCategoryDao.getAll());
//		
//		bookCategoryDao.insert(bookCategory);
	}
}
