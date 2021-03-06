package com.databasegroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.City;
import com.databasegroup.model.User;

public interface IUserService extends IBaseService<User> {
	boolean authUser(User user);
	User getUserByUserNum(@Param("userNum")String usernum);
	List<User> getLimitUsers(@Param("start")int start,@Param("num")int num);
	void addEncashingAmount(int userId, double amount);
	User updateUserEncashingAmount(int userId);
}
