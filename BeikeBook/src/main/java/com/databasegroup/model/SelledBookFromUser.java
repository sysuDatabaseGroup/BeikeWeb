package com.databasegroup.model;

import java.util.Date;

public class SelledBookFromUser {
	private double sellingPrice;
	private String title;
	private String dealedNum;
	private Date datetime;
	private String coverPath;
	
	@Override
	public String toString() {
		return "[" + sellingPrice + ' ' + title + ' ' + 
				dealedNum + ' ' + datetime + ' ' + coverPath + ']';
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the coverPath
	 */
	public String getCoverPath() {
		return coverPath;
	}

	/**
	 * @param coverPath the coverPath to set
	 */
	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	
}
