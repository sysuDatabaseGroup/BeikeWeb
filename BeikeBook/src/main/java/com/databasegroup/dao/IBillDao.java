package com.databasegroup.dao;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.Bill;

@Repository
public interface IBillDao extends IBaseDao<Bill> {
	public double getTotal();
}
