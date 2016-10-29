package com.databasegroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.RentingOrder;
import com.databasegroup.model.SellingOrder;

@Repository
public interface ISellingOrderDao extends IBaseDao<SellingOrder> {
	List<SellingOrder> getSellingOrdersByUserId(int id);
}
