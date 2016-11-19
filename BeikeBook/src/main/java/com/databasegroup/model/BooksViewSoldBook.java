package com.databasegroup.model;

import java.util.Date;
import java.util.List;

public class BooksViewSoldBook {
	
	private String dealedNums;
	private String title;
	private double sellingPrice;
	private String coverPath;
	private Date selledDatetime;
	private int amount;
	
	@Override
	public String toString() {
		return "[" + dealedNums + ' ' + title + ' ' + sellingPrice + ' ' +
				coverPath + ' ' + selledDatetime + ' ' + amount + ']';
	}

	/**
	 * @return the dealedNums
	 */
	public String getDealedNums() {
		return dealedNums;
	}

	/**
	 * @param dealedNums the dealedNums to set
	 */
	public void setDealedNums(String dealedNums) {
		this.dealedNums = dealedNums;
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

	/**
	 * @return the selledDatetime
	 */
	public Date getSelledDatetime() {
		return selledDatetime;
	}

	/**
	 * @param selledDatetime the selledDatetime to set
	 */
	public void setSelledDatetime(Date selledDatetime) {
		this.selledDatetime = selledDatetime;
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
	
}
