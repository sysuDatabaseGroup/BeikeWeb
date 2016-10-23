package com.databasegroup.service;

import java.util.List;

import com.databasegroup.model.City;

public interface ICityService extends IBaseService<City> {
	List<City> getCityByCityNum(String cityNum);
}
