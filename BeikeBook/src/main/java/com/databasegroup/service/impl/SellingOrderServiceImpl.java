package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.ISellingOrderDao;
import com.databasegroup.model.SellingOrder;
import com.databasegroup.service.ISellingOrderService;

@Service("sellingOrderService")
public class SellingOrderServiceImpl implements ISellingOrderService {
	
	@Resource
	private ISellingOrderDao sellingOrderDao;

	@Override
	public void insert(SellingOrder entity) {
		sellingOrderDao.insert(entity);
	}

	@Override
	public void update(SellingOrder entity) {
		sellingOrderDao.update(entity);
	}

	@Override
	public void delete(int id) {
		sellingOrderDao.delete(id);
	}

	@Override
	public SellingOrder getById(int id) {
		return sellingOrderDao.getById(id);
	}

	@Override
	public List<SellingOrder> getAll() {
		return sellingOrderDao.getAll();
	}

	@Override
	public List<SellingOrder> getSellingOrdersByUserId(int id) {
		return sellingOrderDao.getSellingOrdersByUserId(id);
	}
}
