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
}
