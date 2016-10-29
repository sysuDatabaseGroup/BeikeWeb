package com.databasegroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.City;
import com.databasegroup.model.RentingOrder;
import com.databasegroup.model.User;

public interface IRentingOrderService extends IBaseService<RentingOrder> {
	List<RentingOrder> getRentingOrdersByUserId(int id);
}
