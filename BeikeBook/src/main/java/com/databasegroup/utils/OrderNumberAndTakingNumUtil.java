package com.databasegroup.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class OrderNumberAndTakingNumUtil {
	
	private static final int MAX_INT = 99999999;
	private static final int MAX_LENGTH = 7;
	private static final int MAX_TAKING_NUM = 10000;
	
	//订单号=8位日期+用户ID（后7位，数字字母）+随机数（8）
	public static String nextId(String userId) {
		String date = new SimpleDateFormat("yyyyMMdd")
				.format(new Date());
		userId = userId.substring(userId.length()-7).toUpperCase();
    	int i = getNum();
    	while (i > MAX_INT) i = getNum();
    	return "test"+date + userId + String.format("%08d", i);
	}
	
	private static int getNum() {
		int i = Integer.parseInt(
    			UUID.randomUUID()
    			.toString().replace("-", "").substring(0, MAX_LENGTH), 
    			16);
		return i;
	}
	
	public static String getTakingNum() {
		int r = new Random().nextInt(MAX_TAKING_NUM);
		return String.format("%04d", r);
	}
	
	public static void main(String[] args) {
		String s = "7654321";
		System.out.println(s.substring(s.length()-6));
	}
}
