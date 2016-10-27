package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IDistrictDao;
import com.databasegroup.model.District;
import com.databasegroup.service.IDistrictService;

@Service("districtService")
public class DistrictServiceImpl implements IDistrictService {
	
	@Resource
	private IDistrictDao districtDao;

	@Override
	public void insert(District entity) {
		districtDao.insert(entity);
	}

	@Override
	public void update(District entity) {
		districtDao.update(entity);
	}

	@Override
	public void delete(int id) {
		districtDao.delete(id);
	}

	@Override
	public District getById(int id) {
		return districtDao.getById(id);
	}

	@Override
	public List<District> getAll() {
		return districtDao.getAll();
	}
}
