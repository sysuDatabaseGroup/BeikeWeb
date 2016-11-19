package com.databasegroup.aop;

import com.databasegroup.model.User;
import com.databasegroup.utils.MD5Util;

public class EncryptUser {
	public void encrypUser(User user) {
		String password = user.getPassword();
		user.setPassword(MD5Util.encrypt(password));;
	}
}
