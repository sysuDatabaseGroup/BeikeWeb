package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IBookCategoryDao;
import com.databasegroup.dao.IBookDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IUserDao;
import com.databasegroup.model.Book;
import com.databasegroup.model.BookCategory;
import com.databasegroup.model.City;
import com.databasegroup.model.User;
import com.databasegroup.service.IBookCategoryService;
import com.databasegroup.service.IBookService;
import com.databasegroup.service.ICityService;
import com.databasegroup.service.IUserService;

@Service("bookService")
public class BookServiceImpl implements IBookService {
	
	@Resource
	private IBookDao bookDao;

	@Override
	public void insert(Book entity) {
		bookDao.insert(entity);
	}

	@Override
	public void update(Book entity) {
		bookDao.update(entity);
	}

	@Override
	public void delete(int id) {
		bookDao.delete(id);
	}

	@Override
	public Book getById(int id) {
		return bookDao.getById(id);
	}

	@Override
	public List<Book> getAll() {
		return bookDao.getAll();
	}

}
