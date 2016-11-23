package com.databasegroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.Banner;

@Repository
public interface IBannerDao extends IBaseDao<Banner> {
	void updateExceptPic(Banner banner);
	List<Banner> getOrderByPrior();
}
