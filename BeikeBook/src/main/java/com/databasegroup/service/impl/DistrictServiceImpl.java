package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IDistrictDao;
import com.databasegroup.model.District;
import com.databasegroup.model.DistrictStoredSituation;
import com.databasegroup.service.IDistrictService;

@Service("districtService")
public class DistrictServiceImpl implements IDistrictService {
	
	@Resource
	private IDistrictDao districtDao;

	@Override
	public void insert(District entity) {
		districtDao.insert(entity);
	}

	@Override
	public void update(District entity) {
		districtDao.update(entity);
	}

	@Override
	public void delete(int id) {
		districtDao.delete(id);
	}

	@Override
	public District getById(int id) {
		return districtDao.getById(id);
	}

	@Override
	public List<District> getAll() {
		return districtDao.getAll();
	}

	@Override
	public List<District> getDistrictBySchoolId(int id) {
		return districtDao.getDistrictBySchoolId(id);
	}

	@Override
	public List<DistrictStoredSituation> getSituationByBookId(int id) {
		return districtDao.getSituationByBookId(id);
	}
	
	@Override
	public void deleteBySchoolId(int id) {
		districtDao.deleteBySchoolId(id);
	}
	
	@Override
	public List<District> getLimitDistricts(int start,int num) {
		return districtDao.getLimitDistricts(start,num);
	}
	
	@Override
	public List<District> getLimitDistrictsBySchool(int schoolId,int start,int num) {
		return districtDao.getLimitDistrictsBySchool(schoolId,start,num);
	}
}
