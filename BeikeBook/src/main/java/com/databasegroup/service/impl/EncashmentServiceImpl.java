package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IEncashmentDao;
import com.databasegroup.model.Encashment;
import com.databasegroup.service.IEncashmentService;

@Service("encashmentService")
public class EncashmentServiceImpl implements IEncashmentService {
	
	@Resource
	private IEncashmentDao encashmentDao;

	@Override
	public void insert(Encashment entity) {
		encashmentDao.insert(entity);
	}

	@Override
	public void update(Encashment entity) {
		encashmentDao.update(entity);
	}

	@Override
	public void delete(int id) {
		encashmentDao.delete(id);
	}

	@Override
	public Encashment getById(int id) {
		return encashmentDao.getById(id);
	}

	@Override
	public List<Encashment> getAll() {
		return encashmentDao.getAll();
	}
}
