package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IDealedBookDao;
import com.databasegroup.dao.IUserDao;
import com.databasegroup.model.City;
import com.databasegroup.model.User;
import com.databasegroup.service.ICityService;
import com.databasegroup.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private IUserDao userDao;
	
	@Resource
	private IDealedBookDao dealedBookDao;

	@Override
	public void insert(User entity) {
		if (entity.getWxPhoto() == null || entity.getWxPhoto().length() == 0) {
			entity.setWxPhoto("/images/user/default.png");
		}
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
	public boolean authUser(User user) {
		return userDao.authUser(user.getUserNum(), user.getPassword()) != null;
	}

	@Override
	public User getUserByUserNum(String usernum) {
		return userDao.getUserByUserNum(usernum);
	}
	
	@Override
	public List<User> getLimitUsers(int start,int num) {
		return userDao.getLimitUsers(start,num);
	}

	@Override
	public void addEncashingAmount(int userId, double amount) {
		userDao.addEncashingAmount(userId, amount);
	}
	
	@Override
	public User updateUserEncashingAmount(int userId) {
		double encashingAmount = 
				dealedBookDao.getEncashingAmountByUserId(userId);
		User user = userDao.getById(userId);
		user.setWithdrawalAmount(encashingAmount);
		userDao.update(user);
		return user;
	}

}
