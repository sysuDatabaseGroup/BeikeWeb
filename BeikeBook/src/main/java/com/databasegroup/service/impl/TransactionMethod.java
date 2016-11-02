package com.databasegroup.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.model.Encashment;
import com.databasegroup.model.User;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IEncashmentService;
import com.databasegroup.service.IUserService;

@Service("transactionMethod")
public class TransactionMethod {
	
	@Resource
	private IEncashmentService encashmentService;
	
	@Resource
	private IDealedBookService dealedBookService;
	
	@Resource
	private IUserService userService;
	
	public boolean insertEncashment(Encashment encashment, 
				int userId) {
		
		// 可能事务并发问题
		User user = userService.updateUserEncashingAmount(userId);
		if (user.getWithdrawalAmount() == 0) return false;
		encashment.setEncashingAmount(user.getWithdrawalAmount());
		encashment.setUserId(userId);
		user.setWithdrawalAmount(0);
		
		encashmentService.insert(encashment);
		dealedBookService.setEncashedByUser(userId);
		userService.update(user);
		
		return true;
	}
}
