package com.databasegroup.model;

public class Method {
	private int methodID;
	private String methodName;
	private int price;
	
	@Override
	public String toString() {
		return "" + methodID + ' ' + methodName + ' ' + price;
	}
	
	/**
	 * @return the methodID
	 */
	public int getMethodID() {
		return methodID;
	}
	/**
	 * @param methodID the methodID to set
	 */
	public void setMethodID(int methodID) {
		this.methodID = methodID;
	}
	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}
	/**
	 * @param methodName the methodName to set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
