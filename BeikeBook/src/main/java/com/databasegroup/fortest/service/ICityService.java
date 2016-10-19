package com.databasegroup.fortest.service;

import org.springframework.stereotype.Component;

import com.databasegroup.fortest.pojo.City;

public interface ICityService {
	City getCity(City city);
	void addCity(City city);
}
