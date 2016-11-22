package com.databasegroup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.RentingOrder;

@Repository
public interface IRentingOrderDao extends IBaseDao<RentingOrder> {
	List<RentingOrder> getRentingOrdersByUserId(int id);
	List<RentingOrder> getLimitNoTookOrders(@Param("start")int start,@Param("num")int num,@Param("take_num")String take_num);
	List<RentingOrder> getLimitOrders(@Param("start")int start,@Param("num")int num,@Param("take_num")String take_num);
}
