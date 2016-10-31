package com.databasegroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.City;

@Repository
public interface ICityDao extends IBaseDao<City> {
	List<City> getCityByCityNum(String cityNum);
	List<City> getLimitCities(@Param("start")int start,@Param("num")int num);
}
