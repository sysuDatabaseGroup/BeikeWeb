package com.databasegroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.School;

@Repository
public interface ISchoolDao extends IBaseDao<School> {
	void deleteByCityId(int id);
	List<School> getLimitSchools(@Param("start")int start,@Param("num")int num);
	List<School> getLimitSchoolsByAdmin(@Param("start")int start,@Param("num")int num,@Param("admin")String admin);
	School getByAdmin(String admin);
}
