package com.databasegroup.fortest.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.databasegroup.fortest.dao.ICityDao;
import com.databasegroup.fortest.pojo.City;
import com.databasegroup.fortest.service.ICityService;

@Service("cityService")
public class CityServiceImpl implements ICityService {
	
	@Resource
	private ICityDao cityDao;

	public City getCity(City city) {
		return cityDao.getCity(city);
	}

	public void addCity(City city) {
		cityDao.addCity(city);
	}

}
