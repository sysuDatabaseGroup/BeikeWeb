package com.databasegroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.District;
import com.databasegroup.model.DistrictStoredSituation;

@Repository
public interface IDistrictDao extends IBaseDao<District> {
	List<District> getDistrictBySchoolId(int id);
	
	List<DistrictStoredSituation> getSituationByBookId(int id);
}
