package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.ICityDao;
import com.databasegroup.model.City;
import com.databasegroup.service.ICityService;

@Service("cityService")
public class CityServiceImpl implements ICityService {
	
	@Resource
	private ICityDao cityDao;

	public void insert(City entity) {
		cityDao.insert(entity);
	}

	public void update(City entity) {
		cityDao.update(entity);
	}

	public void delete(int id) {
		cityDao.delete(id);
	}

	public City getById(int id) {
		return cityDao.getById(id);
	}

	public List<City> getAll() {
		return cityDao.getAll();
	}

	public List<City> getCityByCityNum(String cityNum) {
		// TODO Auto-generated method stub
		return cityDao.getCityByCityNum(cityNum);
	}
}
