package com.databasegroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.City;

public interface ICityService extends IBaseService<City> {
	List<City> getCityByCityNum(String cityNum);
	List<City> getLimitCities(@Param("start")int start,@Param("num")int num);
}
