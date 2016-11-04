package com.databasegroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.City;
import com.databasegroup.model.School;
import com.databasegroup.model.User;

public interface ISchoolService extends IBaseService<School> {
	void deleteByCityId(int id);
	List<School> getLimitSchools(@Param("start")int start,@Param("num")int num);
	List<School> getLimitSchoolsByAdmin(@Param("start")int start,@Param("num")int num,@Param("admin")String admin);
	School getByAdmin(String admin);
}
