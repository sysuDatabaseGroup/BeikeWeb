package com.databasegroup.service;

import java.util.List;

import com.databasegroup.model.Admin;

public interface IAdminService extends IBaseService<Admin> {
	boolean authUser(String name, String password);
	Admin getByName(String name);
	void deleteByName(String name);
}
