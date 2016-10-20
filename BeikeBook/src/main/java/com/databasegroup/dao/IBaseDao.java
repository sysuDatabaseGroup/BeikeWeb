package com.databasegroup.dao;

import java.util.List;

public interface IBaseDao<T> {
	void insert(T entity);
	void update(T entity);
	void delete(int id);
	T getById(int id);
	List<T> getAll();
}
