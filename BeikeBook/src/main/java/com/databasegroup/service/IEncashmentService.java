package com.databasegroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.City;
import com.databasegroup.model.Encashment;
import com.databasegroup.model.User;

public interface IEncashmentService extends IBaseService<Encashment> {
	double getEncashingAmountById(int id);
}
