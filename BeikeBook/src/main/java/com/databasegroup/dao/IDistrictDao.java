package com.databasegroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.District;

@Repository
public interface IDistrictDao extends IBaseDao<District> {
	List<District> getDistrictBySchoolId(int id);
}
