package com.databasegroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.City;
import com.databasegroup.model.District;
import com.databasegroup.model.User;

public interface IDistrictService extends IBaseService<District> {
	List<District> getDistrictBySchoolId(int id);
}
