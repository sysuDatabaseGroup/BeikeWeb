package com.databasegroup.service;

import java.util.List;

public interface IBaseService<T> {
	void insert(T entity);
	void update(T entity);
	void delete(int id);
	T getById(int id);
	List<T> getAll();
}
