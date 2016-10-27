package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IRentingOrderDao;
import com.databasegroup.model.RentingOrder;
import com.databasegroup.service.IRentingOrderService;

@Service("rentingOrderService")
public class RentingOrderServiceImpl implements IRentingOrderService {
	
	@Resource
	private IRentingOrderDao rentingOrderDao;

	@Override
	public void insert(RentingOrder entity) {
		rentingOrderDao.insert(entity);
	}

	@Override
	public void update(RentingOrder entity) {
		rentingOrderDao.update(entity);
	}

	@Override
	public void delete(int id) {
		rentingOrderDao.delete(id);
	}

	@Override
	public RentingOrder getById(int id) {
		return rentingOrderDao.getById(id);
	}

	@Override
	public List<RentingOrder> getAll() {
		return rentingOrderDao.getAll();
	}
}
