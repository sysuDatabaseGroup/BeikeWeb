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

	@Override
	public double getEncashingAmountById(int id) {
		return encashmentDao.getEncashingAmountById(id);
	}

	@Override
	public List<Encashment> getNoEncashed() {
		return encashmentDao.getNoEncashed();
	}

	@Override
	public List<Encashment> getEncashed() {
		return encashmentDao.getEncashed();
	}

	@Override
	public List<Encashment> getEncashedByAlipayAccount(String alipayAccount) {
		return encashmentDao.getEncashedByAlipayAccount(alipayAccount);
	}

	@Override
	public void setEncashedById(int id) {
		encashmentDao.setEncashedById(id);
	}
}
