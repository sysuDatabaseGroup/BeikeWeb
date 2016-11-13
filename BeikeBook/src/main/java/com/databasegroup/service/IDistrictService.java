package com.databasegroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.City;
import com.databasegroup.model.District;
import com.databasegroup.model.DistrictStoredSituation;
import com.databasegroup.model.User;

public interface IDistrictService extends IBaseService<District> {
	List<District> getDistrictBySchoolId(int id);
	List<DistrictStoredSituation> getSituationByBookId(int id);
	void deleteBySchoolId(int id);
	List<District> getLimitDistricts(@Param("start")int start,@Param("num")int num);
	List<District> getLimitDistrictsBySchool(@Param("schoolId")int schoolId,@Param("start")int start,@Param("num")int num);
}
