package com.databasegroup.model;

public class Money {
	private int moneyID;
	private String alipayAccount;
	private String alipayName;
	private int moneyNum;
	private String phone;
	
	@Override
	public String toString() {
		return "" + moneyID + ' ' + alipayAccount + ' ' + 
				alipayName + ' ' + moneyNum + ' ' + phone;
	}
	
	/**
	 * @return the moneyID
	 */
	public int getMoneyID() {
		return moneyID;
	}
	/**
	 * @param moneyID the moneyID to set
	 */
	public void setMoneyID(int moneyID) {
		this.moneyID = moneyID;
	}
	/**
	 * @return the alipayAccount
	 */
	public String getAlipayAccount() {
		return alipayAccount;
	}
	/**
	 * @param alipayAccount the alipayAccount to set
	 */
	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}
	/**
	 * @return the alipayName
	 */
	public String getAlipayName() {
		return alipayName;
	}
	/**
	 * @param alipayName the alipayName to set
	 */
	public void setAlipayName(String alipayName) {
		this.alipayName = alipayName;
	}
	/**
	 * @return the moneyNum
	 */
	public int getMoneyNum() {
		return moneyNum;
	}
	/**
	 * @param moneyNum the moneyNum to set
	 */
	public void setMoneyNum(int moneyNum) {
		this.moneyNum = moneyNum;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
