package com.databasegroup.model;

public class Encashment {
	private int id;
	private int userId;
	private String alipayAccount;
	private String alipayName;
	private double encashingAmount;
	private String phone;
	private int encashed;
	
	@Override
	public String toString() {
		return "[" + id + ' ' + userId + ' ' + alipayAccount + ' ' + 
				alipayName + ' ' + encashingAmount + ' ' + phone + ' ' +
				encashed + ']';
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
	public double getEncashingAmount() {
		return encashingAmount;
	}

	/**
	 * @param encashingAmount the encashingAmount to set
	 */
	public void setEncashingAmount(double encashingAmount) {
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

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the encashed
	 */
	public int getEncashed() {
		return encashed;
	}

	/**
	 * @param encashed the encashed to set
	 */
	public void setEncashed(int encashed) {
		this.encashed = encashed;
	}
	
	
}
