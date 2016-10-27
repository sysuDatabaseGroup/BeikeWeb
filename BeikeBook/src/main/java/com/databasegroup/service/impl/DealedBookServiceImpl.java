package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IDealedBookDao;
import com.databasegroup.dao.IUserDao;
import com.databasegroup.model.City;
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.User;
import com.databasegroup.service.ICityService;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IUserService;

@Service("dealedBookService")
public class DealedBookServiceImpl implements IDealedBookService {
	
	@Resource
	private IDealedBookDao dealedBookDao;

	@Override
	public void insert(DealedBook entity) {
		dealedBookDao.insert(entity);
	}

	@Override
	public void update(DealedBook entity) {
		dealedBookDao.update(entity);
	}

	@Override
	public void delete(int id) {
		dealedBookDao.delete(id);
	}

	@Override
	public DealedBook getById(int id) {
		return dealedBookDao.getById(id);
	}

	@Override
	public List<DealedBook> getAll() {
		return dealedBookDao.getAll();
	}


}
