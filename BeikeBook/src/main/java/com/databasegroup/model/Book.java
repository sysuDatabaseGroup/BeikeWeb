package com.databasegroup.model;

import java.util.Date;

public class Book {
	private int bookID;
	private int bookClassID;
	private String bookNum;
	private double sellPrice;
	private double borrowPrice;
	private int districtID;
	private int userID;
	private Date datetime;
	private int isSell;
	
	@Override
	public String toString() {
		return "" + bookID + ' ' + bookClassID + ' ' + bookNum + ' ' +
				sellPrice + ' ' + borrowPrice + ' ' + districtID + ' ' +
				userID + ' ' + datetime + ' ' + isSell;
	}
	
	/**
	 * @return the bookID
	 */
	public int getBookID() {
		return bookID;
	}
	/**
	 * @param bookID the bookID to set
	 */
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	/**
	 * @return the bookClassID
	 */
	public int getBookClassID() {
		return bookClassID;
	}
	/**
	 * @param bookClassID the bookClassID to set
	 */
	public void setBookClassID(int bookClassID) {
		this.bookClassID = bookClassID;
	}
	/**
	 * @return the bookNum
	 */
	public String getBookNum() {
		return bookNum;
	}
	/**
	 * @param bookNum the bookNum to set
	 */
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	/**
	 * @return the sellPrice
	 */
	public double getSellPrice() {
		return sellPrice;
	}
	/**
	 * @param sellPrice the sellPrice to set
	 */
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	/**
	 * @return the borrowPrice
	 */
	public double getBorrowPrice() {
		return borrowPrice;
	}
	/**
	 * @param borrowPrice the borrowPrice to set
	 */
	public void setBorrowPrice(double borrowPrice) {
		this.borrowPrice = borrowPrice;
	}
	/**
	 * @return the districtID
	 */
	public int getDistrictID() {
		return districtID;
	}
	/**
	 * @param districtID the districtID to set
	 */
	public void setDistrictID(int districtID) {
		this.districtID = districtID;
	}
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
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
	 * @return the isSell
	 */
	public int getIsSell() {
		return isSell;
	}
	/**
	 * @param isSell the isSell to set
	 */
	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}
}
