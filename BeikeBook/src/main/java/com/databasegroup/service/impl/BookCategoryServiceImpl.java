package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IBookCategoryDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IUserDao;
import com.databasegroup.model.BookCategory;
import com.databasegroup.model.City;
import com.databasegroup.model.User;
import com.databasegroup.service.IBookCategoryService;
import com.databasegroup.service.ICityService;
import com.databasegroup.service.IUserService;

@Service("bookCategoryService")
public class BookCategoryServiceImpl implements IBookCategoryService {
	
	@Resource
	private IBookCategoryDao bookCategoryDao;

	@Override
	public void insert(BookCategory entity) {
		if (entity.getIconPath() == null || entity.getIconPath().length() == 0) {
			entity.setIconPath("/images/bookCategory/default.png");
		}
		bookCategoryDao.insert(entity);
	}

	@Override
	public void update(BookCategory entity) {
		bookCategoryDao.update(entity);
	}

	@Override
	public void delete(int id) {
		bookCategoryDao.delete(id);
	}

	@Override
	public BookCategory getById(int id) {
		return bookCategoryDao.getById(id);
	}

	@Override
	public List<BookCategory> getAll() {
		return bookCategoryDao.getAll();
	}
}
