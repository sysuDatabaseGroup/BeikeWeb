package com.databasegroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.RentingOrder;

@Repository
public interface IRentingOrderDao extends IBaseDao<RentingOrder> {
	List<RentingOrder> getRentingOrdersByUserId(int id);
}
