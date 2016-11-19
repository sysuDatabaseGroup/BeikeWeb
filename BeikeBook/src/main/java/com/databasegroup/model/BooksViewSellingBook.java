package com.databasegroup.model;

import java.util.Date;
import java.util.List;

public class BooksViewSellingBook {
	
	private String title;
	private String dealedNums;
	private String districtName;
	private String schoolName;
	private Date datetime;
	private String coverPath;
	private int amount;
	
	@Override
	public String toString() {
		return "[" + title + ' ' + dealedNums + ' ' + districtName + ' ' +
				schoolName + ' ' + datetime + ' ' + coverPath + ' ' +
				amount + ']';
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
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
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
