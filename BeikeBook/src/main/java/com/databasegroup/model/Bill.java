package com.databasegroup.model;

public class Bill {
	private int billID;
	private String info;
	private double amount;

	public Bill(String info,int amount){
		this.info = info;
		this.amount = amount;
	}

	public String getInfo(){
		return this.info;
	}

	public double getAmount(){
		return this.amount;
	}

	public int getID(){
		return this.billID;
	}
}
