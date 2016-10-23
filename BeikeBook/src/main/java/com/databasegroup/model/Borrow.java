package com.databasegroup.model;

import java.util.Date;

public class Borrow {
	private int borrowID;
	private int userID;
	private int methodID;
	private int bookID;
	private int num;
	private Date datetime;
	private String takeBookNum;
	private int isTake;
	private int isBack;
	
	@Override
	public String toString() {
		return "" + borrowID + ' ' + userID + ' ' + methodID + ' ' + bookID + ' ' +
				num + ' ' + datetime + ' ' + takeBookNum + ' ' + isTake + ' ' + isBack;
	}
	
	/**
	 * @return the borrowID
	 */
	public int getBorrowID() {
		return borrowID;
	}
	/**
	 * @param borrowID the borrowID to set
	 */
	public void setBorrowID(int borrowID) {
		this.borrowID = borrowID;
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
	 * @return the isTake
	 */
	public int getIsTake() {
		return isTake;
	}
	/**
	 * @param isTake the isTake to set
	 */
	public void setIsTake(int isTake) {
		this.isTake = isTake;
	}
	/**
	 * @return the isBack
	 */
	public int getIsBack() {
		return isBack;
	}
	/**
	 * @param isBack the isBack to set
	 */
	public void setIsBack(int isBack) {
		this.isBack = isBack;
	}
	
	
}
