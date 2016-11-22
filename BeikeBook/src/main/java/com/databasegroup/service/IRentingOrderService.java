package com.databasegroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.City;
import com.databasegroup.model.RentingOrder;
import com.databasegroup.model.SellingOrder;
import com.databasegroup.model.User;

public interface IRentingOrderService extends IBaseService<RentingOrder> {
	List<RentingOrder> getRentingOrdersByUserId(int id);
	void insertOrder(RentingOrder rentingOrder);
	RentingOrder getOrderById(int id);
	List<RentingOrder> getLimitNoTookOrders(@Param("start")int start,@Param("num")int num,@Param("take_num")String take_num);
	List<RentingOrder> getLimitOrders(@Param("start")int start,@Param("num")int num,@Param("take_num")String take_num);
}
