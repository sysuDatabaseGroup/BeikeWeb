package com.databasegroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.City;
import com.databasegroup.model.SellingOrder;
import com.databasegroup.model.User;

public interface ISellingOrderService extends IBaseService<SellingOrder> {
	List<SellingOrder> getSellingOrdersByUserId(int id);
	void insertOrder(SellingOrder sellingOrder);
	SellingOrder getOrderById(int id);
}
