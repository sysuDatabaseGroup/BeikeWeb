package com.databasegroup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.databasegroup.model.Encashment;

@Repository
public interface IEncashmentDao extends IBaseDao<Encashment> {
	double getEncashingAmountById(int id);
	List<Encashment> getNoEncashed();
	List<Encashment> getEncashed();
	List<Encashment> getEncashedByAlipayAccount(
			@Param("alipayAccount") String alipayAccount);
	void setEncashedById(int id);
}
