package com.databasegroup.model;

import java.util.Date;

public class RentingOrder {
	private int id;
	private int userId;
	private int deliveryMethodId;
	private int dealedBookId;
	private int amount;
	private Date datetime;
	private String takingBookNum;
	private int took;
	private int returned;
	
	@Override
	public String toString() {
		return "" + id + ' ' + userId + ' ' + deliveryMethodId + ' ' + dealedBookId + ' ' +
				amount + ' ' + datetime + ' ' + takingBookNum + ' ' + took + ' ' + returned;
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
	 * @return the userID
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserId(int userID) {
		this.userId = userID;
	}

	/**
	 * @return the deliveryMethodId
	 */
	public int getDeliveryMethodId() {
		return deliveryMethodId;
	}

	/**
	 * @param deliveryMethodId the deliveryMethodId to set
	 */
	public void setDeliveryMethodId(int deliveryMethodId) {
		this.deliveryMethodId = deliveryMethodId;
	}

	/**
	 * @return the dealedBookId
	 */
	public int getDealedBookId() {
		return dealedBookId;
	}

	/**
	 * @param dealedBookId the dealedBookId to set
	 */
	public void setDealedBookId(int dealedBookId) {
		this.dealedBookId = dealedBookId;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the datetime
	 */
	public Date getDatetime() {
		return datetime;
	}

	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	/**
	 * @return the takingBookNum
	 */
	public String getTakingBookNum() {
		return takingBookNum;
	}

	/**
	 * @param takingBookNum the takingBookNum to set
	 */
	public void setTakingBookNum(String takingBookNum) {
		this.takingBookNum = takingBookNum;
	}

	/**
	 * @return the took
	 */
	public int getTook() {
		return took;
	}

	/**
	 * @param took the took to set
	 */
	public void setTook(int took) {
		this.took = took;
	}

	/**
	 * @return the returned
	 */
	public int getReturned() {
		return returned;
	}

	/**
	 * @param returned the returned to set
	 */
	public void setReturned(int returned) {
		this.returned = returned;
	}
}
