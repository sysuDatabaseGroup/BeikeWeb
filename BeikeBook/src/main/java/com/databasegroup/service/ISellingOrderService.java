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
	List<SellingOrder> getLimitNoTookOrders(@Param("start")int start,@Param("num")int num,@Param("take_num")String take_num);
	List<SellingOrder> getLimitOrders(@Param("start")int start,@Param("num")int num,@Param("take_num")String take_num);
}
