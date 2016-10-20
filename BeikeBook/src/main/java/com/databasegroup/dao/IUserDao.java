package com.databasegroup.dao;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.User;

@Repository
public interface IUserDao extends IBaseDao<User> {
}
