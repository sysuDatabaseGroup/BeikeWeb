package com.databasegroup.model;

import java.util.Date;

public class Sell {
	private int sellID;
	private int userID;
	private int methodID;
	private int bookID;
	private int num;
	private Date datetime;
	private String takeBookNum;
	private int isMoney;
	
	@Override
	public String toString() {
		return "" + sellID + ' ' + userID + ' ' + methodID + ' ' + 
				bookID + ' ' + num + ' ' + datetime + ' ' + ' ' +
				takeBookNum + ' ' + isMoney;
	}
	
	/**
	 * @return the sellID
	 */
	public int getSellID() {
		return sellID;
	}
	/**
	 * @param sellID the sellID to set
	 */
	public void setSellID(int sellID) {
		this.sellID = sellID;
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
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
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
	 * @param datetime the datetime to set
	 */
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	/**
	 * @return the takeBookNum
	 */
	public String getTakeBookNum() {
		return takeBookNum;
	}
	/**
	 * @param takeBookNum the takeBookNum to set
	 */
	public void setTakeBookNum(String takeBookNum) {
		this.takeBookNum = takeBookNum;
	}
	/**
	 * @return the isMoney
	 */
	public int getIsMoney() {
		return isMoney;
	}
	/**
	 * @param isMoney the isMoney to set
	 */
	public void setIsMoney(int isMoney) {
		this.isMoney = isMoney;
	}
}
