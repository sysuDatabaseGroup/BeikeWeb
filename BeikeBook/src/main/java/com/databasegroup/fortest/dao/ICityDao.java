package com.databasegroup.fortest.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.databasegroup.fortest.pojo.City;

@Repository
public interface ICityDao {
	City getCity(City city);
	void addCity(City city);
}
