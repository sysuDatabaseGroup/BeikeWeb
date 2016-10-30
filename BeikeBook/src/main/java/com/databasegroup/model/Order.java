package com.databasegroup.model;

import java.util.Date;
import java.util.List;

public class Order {
	
	protected int id;
	protected int userId;
	protected int deliveryMethodId;
	// 标记这个订单所买的书
	protected int bookId;
	protected List<DealedBook> dealedBooks;
	// 由于订单里包含对应课本的数目，所以dealedBookId字段也应该包含多本书，所以设计成字符串
	// 每本书用 | 来分隔组成一个字符串
	protected String dealedBookIds;
	protected int amount;
	protected Date datetime;
	protected String takingBookNum;
	protected int isRenting;
	
	@Override
	public String toString() {
		return "[" + id + ' ' + userId + ' ' + deliveryMethodId + ' '
				+ dealedBooks + ' ' + amount + ' ' + datetime + ' ' +
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

	/**
	 * @return the dealedBooks
	 */
	public List<DealedBook> getDealedBooks() {
		return dealedBooks;
	}

	/**
	 * @param dealedBooks the dealedBooks to set
	 */
	public void setDealedBooks(List<DealedBook> dealedBooks) {
		this.dealedBooks = dealedBooks;
	}

	/**
	 * @return the dealedBookIds
	 */
	public String getDealedBookIds() {
		return dealedBookIds;
	}

	/**
	 * @param dealedBookIds the dealedBookIds to set
	 */
	public void setDealedBookIds(String dealedBookIds) {
		this.dealedBookIds = dealedBookIds;
	}

	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	
	
}
