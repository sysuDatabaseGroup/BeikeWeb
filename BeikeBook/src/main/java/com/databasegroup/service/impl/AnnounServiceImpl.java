package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IAnnounDao;
import com.databasegroup.model.Announ;
import com.databasegroup.service.IAnnounService;

@Service("announService")
public class AnnounServiceImpl implements IAnnounService {
	
	@Resource
	private IAnnounDao announDao;

	@Override
	public void insert(Announ entity) {
		announDao.insert(entity);
	}

	@Override
	public void update(Announ entity) {
		announDao.update(entity);
	}

	@Override
	public void delete(int id) {
		announDao.delete(id);
	}

	@Override
	public Announ getById(int id) {
		return announDao.getById(id);
	}

	@Override
	public List<Announ> getAll() {
		return announDao.getAll();
	}
}
