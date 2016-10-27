package com.databasegroup.model;

public class Encashment {
	private int id;
	private String alipayAccount;
	private String alipayName;
	private int encashingAmount;
	private String phone;
	
	@Override
	public String toString() {
		return "[" + id + ' ' + alipayAccount + ' ' + 
				alipayName + ' ' + encashingAmount + ' ' + phone + ']';
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the encashingAmount
	 */
	public int getEncashingAmount() {
		return encashingAmount;
	}

	/**
	 * @param encashingAmount the encashingAmount to set
	 */
	public void setEncashingAmount(int encashingAmount) {
		this.encashingAmount = encashingAmount;
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
