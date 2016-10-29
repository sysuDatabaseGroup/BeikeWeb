package com.databasegroup.model;

import java.util.Date;

public class Order {
	
	protected int id;
	protected int userId;
	protected int deliveryMethodId;
	protected DealedBook dealedBook;
	protected int amount;
	protected Date datetime;
	protected String takingBookNum;
	protected int isRenting;
	
	@Override
	public String toString() {
		return "[" + id + ' ' + userId + ' ' + deliveryMethodId + ' '
				+ dealedBook + ' ' + amount + ' ' + datetime + ' ' +
				takingBookNum + ' ' + isRenting + ']';
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
	 * @return the dealedBook
	 */
	public DealedBook getDealedBook() {
		return dealedBook;
	}

	/**
	 * @param dealedBook the dealedBook to set
	 */
	public void setDealedBook(DealedBook dealedBook) {
		this.dealedBook = dealedBook;
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
	 * @return the isRenting
	 */
	public int getIsRenting() {
		return isRenting;
	}

	/**
	 * @param isRenting the isRenting to set
	 */
	public void setIsRenting(int isRenting) {
		this.isRenting = isRenting;
	}

	
}
