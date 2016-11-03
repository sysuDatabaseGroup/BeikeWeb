package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.ISchoolDao;
import com.databasegroup.model.School;
import com.databasegroup.service.ISchoolService;

@Service("schoolService")
public class SchoolServiceImpl implements ISchoolService {
	
	@Resource
	private ISchoolDao schoolDao;

	@Override
	public void insert(School entity) {
		schoolDao.insert(entity);
	}

	@Override
	public void update(School entity) {
		schoolDao.update(entity);
	}

	@Override
	public void delete(int id) {
		schoolDao.delete(id);
	}

	@Override
	public School getById(int id) {
		return schoolDao.getById(id);
	}

	@Override
	public List<School> getAll() {
		return schoolDao.getAll();
	}
	
	@Override
	public void deleteByCityId(int id) {
		schoolDao.deleteByCityId(id);
	}
	
	@Override
	public School getByAdmin(String admin){
		return schoolDao.getByAdmin(admin);
	}
	
	@Override
	public List<School> getLimitSchools(int start,int num) {
		return schoolDao.getLimitSchools(start,num);
	}
	
	@Override
	public List<School> getLimitSchoolsByAdmin(int start,int num,String admin) {
		return schoolDao.getLimitSchoolsByAdmin(start,num,admin);
	}
}
