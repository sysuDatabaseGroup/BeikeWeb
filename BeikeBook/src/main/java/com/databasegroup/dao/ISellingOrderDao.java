package com.databasegroup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.RentingOrder;
import com.databasegroup.model.SellingOrder;

@Repository
public interface ISellingOrderDao extends IBaseDao<SellingOrder> {
	List<SellingOrder> getSellingOrdersByUserId(int id);
	List<SellingOrder> getLimitNoTookOrders(@Param("start")int start,@Param("num")int num,@Param("take_num")String take_num);
	List<SellingOrder> getLimitOrders(@Param("start")int start,@Param("num")int num,@Param("take_num")String take_num);
}
