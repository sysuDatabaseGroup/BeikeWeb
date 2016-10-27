package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IBannerDao;
import com.databasegroup.model.Banner;
import com.databasegroup.service.IBannerService;

@Service("bannerService")
public class BannerServiceImpl implements IBannerService {
	
	@Resource
	private IBannerDao bannerDao;

	@Override
	public void insert(Banner entity) {
		bannerDao.insert(entity);
	}

	@Override
	public void update(Banner entity) {
		bannerDao.update(entity);
	}

	@Override
	public void delete(int id) {
		bannerDao.delete(id);
	}

	@Override
	public Banner getById(int id) {
		return bannerDao.getById(id);
	}

	@Override
	public List<Banner> getAll() {
		return bannerDao.getAll();
	}
}
