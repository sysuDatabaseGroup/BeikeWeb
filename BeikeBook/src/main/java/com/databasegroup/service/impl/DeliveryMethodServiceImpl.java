package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IDeliveryMethodDao;
import com.databasegroup.model.DeliveryMethod;
import com.databasegroup.service.IDeliveryMethodService;

@Service("deliveryMethodService")
public class DeliveryMethodServiceImpl implements IDeliveryMethodService {
	
	@Resource
	private IDeliveryMethodDao deliveryMethodDao;

	@Override
	public void insert(DeliveryMethod entity) {
		deliveryMethodDao.insert(entity);
	}

	@Override
	public void update(DeliveryMethod entity) {
		deliveryMethodDao.update(entity);
	}

	@Override
	public void delete(int id) {
		deliveryMethodDao.delete(id);
	}

	@Override
	public DeliveryMethod getById(int id) {
		return deliveryMethodDao.getById(id);
	}

	@Override
	public List<DeliveryMethod> getAll() {
		return deliveryMethodDao.getAll();
	}
}
