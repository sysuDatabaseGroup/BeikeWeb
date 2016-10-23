package com.databasegroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.City;

@Repository
public interface ICityDao extends IBaseDao<City> {
	List<City> getCityByCityNum(String cityNum);
}
