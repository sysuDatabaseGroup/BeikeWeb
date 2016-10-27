package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IAdminDao;
import com.databasegroup.model.Admin;
import com.databasegroup.service.IAdminService;

@Service("adminService")
public class AdminServiceImpl implements IAdminService {
	
	@Resource
	private IAdminDao adminDao;

	public void insert(Admin entity) {
		adminDao.insert(entity);
	}

	public void update(Admin entity) {
		adminDao.update(entity);
	}

	public void delete(int id) {
		adminDao.delete(id);
	}

	public Admin getById(int id) {
		return adminDao.getById(id);
	}

	public List<Admin> getAll() {
		return adminDao.getAll();
	}

	public Admin getByName(String name) {
		return adminDao.getByName(name);
	}

	public boolean authUser(String name, String password){
		Admin admin = adminDao.getByName(name);
		if(admin == null){
			return false;
		}
		if(admin.getPassword() == password){
			return true;
		}
		return false;
	}
}
