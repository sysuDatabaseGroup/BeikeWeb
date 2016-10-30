package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.databasegroup.dao.IAnnounDao;
import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IUserDao;
import com.databasegroup.model.Announ;
import com.databasegroup.model.City;
import com.databasegroup.model.User;
import com.databasegroup.service.ICityService;
import com.databasegroup.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private IUserDao userDao;
	
	@Autowired
	private IAnnounDao announDao;

	@Override
	public void insert(User entity) {
		userDao.insert(entity);
	}

	@Override
	public void update(User entity) {
		userDao.update(entity);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public boolean authUser(String usernum, String password) {
		return userDao.authUser(usernum, password) != null;
	}

	@Override
	public User getUserByUserNum(String usernum) {
		return userDao.getUserByUserNum(usernum);
	}
	
//	@Override
//	public void insertTest() {
//		Announ a = new Announ();
//		a.setContent("TestTransac");
//		a.setTitle("TestTransac");
//		announDao.insert(a);
//		announDao.insert(a);
//		announDao.insert(a);
//		User u = new User();
//		u.setUserNum("1234");
//		userDao.insert(u);
//	}

}
