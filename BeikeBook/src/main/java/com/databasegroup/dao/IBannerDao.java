package com.databasegroup.dao;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.Banner;

@Repository
public interface IBannerDao extends IBaseDao<Banner> {
	void updateExceptPic(Banner banner);
}
