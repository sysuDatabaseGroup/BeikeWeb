package com.databasegroup.model;

import java.util.Date;

public class DealedBook {
	private int id;
	private int bookId;
	private String dealedNum;
	private double sellingPrice;
	private double rentalPrice;
	private int districtId;
	private int userId;
	private Date datetime;
	private int selled;
	
	@Override
	public String toString() {
		return "" + id + ' ' + bookId + ' ' + dealedNum + ' ' +
				sellingPrice + ' ' + rentalPrice + ' ' + districtId + ' ' +
				userId + ' ' + datetime + ' ' + selled;
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

	/**
	 * @return the dealedNum
	 */
	public String getDealedNum() {
		return dealedNum;
	}

	/**
	 * @param dealedNum the dealedNum to set
	 */
	public void setDealedNum(String dealedNum) {
		this.dealedNum = dealedNum;
	}

	/**
	 * @return the sellingPrice
	 */
	public double getSellingPrice() {
		return sellingPrice;
	}

	/**
	 * @param sellingPrice the sellingPrice to set
	 */
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	/**
	 * @return the rentalPrice
	 */
	public double getRentalPrice() {
		return rentalPrice;
	}

	/**
	 * @param rentalPrice the rentalPrice to set
	 */
	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	/**
	 * @return the districtId
	 */
	public int getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
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
	 * @return the selled
	 */
	public int getSelled() {
		return selled;
	}

	/**
	 * @param selled the selled to set
	 */
	public void setSelled(int selled) {
		this.selled = selled;
	}
	
	
}
