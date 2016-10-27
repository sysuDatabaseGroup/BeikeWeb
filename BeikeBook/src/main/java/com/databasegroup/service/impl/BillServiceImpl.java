package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IBillDao;
import com.databasegroup.model.Bill;
import com.databasegroup.service.IBillService;

@Service("billService")
public class BillServiceImpl implements IBillService {
	
	@Resource
	private IBillDao billDao;

	@Override
	public void insert(Bill entity) {
		billDao.insert(entity);
	}

	@Override
	public void update(Bill entity) {
		billDao.update(entity);
	}

	@Override
	public void delete(int id) {
		billDao.delete(id);
	}

	@Override
	public Bill getById(int id) {
		return billDao.getById(id);
	}

	@Override
	public List<Bill> getAll() {
		return billDao.getAll();
	}

	@Override
	public double getTotal(){
		return billDao.getTotal();
	}
}
