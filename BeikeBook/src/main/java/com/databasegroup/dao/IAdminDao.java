package com.databasegroup.dao;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.Admin;

@Repository
public interface IAdminDao extends IBaseDao<Admin> {
	public Admin getByName(String name);

}
