package com.databasegroup.model;

import java.util.Date;

public class SellingOrder {
	private int id;
	private int userId;
	private int deliveryMethodId;
	private int dealedBookId;
	private int num;
	private Date datetime;
	private String takingBookNum;
	private int payed;

	@Override
	public String toString() {
		return "" + id + ' ' + userId + ' ' + deliveryMethodId + ' ' + dealedBookId + ' ' + num + ' ' + datetime + ' '
				+ ' ' + takingBookNum + ' ' + payed;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the deliveryMethodId
	 */
	public int getDeliveryMethodId() {
		return deliveryMethodId;
	}

	/**
	 * @param deliveryMethodId
	 *            the deliveryMethodId to set
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
	 * @param dealedBookId
	 *            the dealedBookId to set
	 */
	public void setDealedBookId(int dealedBookId) {
		this.dealedBookId = dealedBookId;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num
	 *            the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the datetime
	 */
	public Date getDatetime() {
		return datetime;
	}

	/**
	 * @param datetime
	 *            the datetime to set
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
	 * @param takingBookNum
	 *            the takingBookNum to set
	 */
	public void setTakingBookNum(String takingBookNum) {
		this.takingBookNum = takingBookNum;
	}

	/**
	 * @return the payed
	 */
	public int getPayed() {
		return payed;
	}

	/**
	 * @param payed
	 *            the payed to set
	 */
	public void setPayed(int payed) {
		this.payed = payed;
	}

}
