package com.databasegroup.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.model.Encashment;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IEncashmentService;

@Service("transactionMethod")
public class TransactionMethod {
	
	@Resource
	private IEncashmentService encashmentService;
	
	@Resource
	private IDealedBookService dealedBookService;
	
	public void insertEncashment(Encashment encashment, 
				int userId) {
		encashmentService.insert(encashment);
		dealedBookService.setEncashedByUser(userId);
	}
}
