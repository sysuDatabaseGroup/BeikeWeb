package com.databasegroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.District;
import com.databasegroup.model.DistrictStoredSituation;

@Repository
public interface IDistrictDao extends IBaseDao<District> {
	List<District> getDistrictBySchoolId(int id);
	void deleteBySchoolId(int id);
	List<DistrictStoredSituation> getSituationByBookId(int id);
	List<District> getLimitDistricts(@Param("start")int start,@Param("num")int num);
	List<District> getLimitDistrictsBySchool(@Param("schoolId")int schoolId,@Param("start")int start,@Param("num")int num);
}
