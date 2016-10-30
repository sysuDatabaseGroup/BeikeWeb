package com.databasegroup.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.databasegroup.model.User;

@Repository
public interface IUserDao extends IBaseDao<User> {
	User authUser(@Param("userNum")String usernum, 
					@Param("password")String password);
	User getUserByUserNum(@Param("userNum")String usernum);
	List<User> getLimitUsers(@Param("start")int start,@Param("num")int num);
}
