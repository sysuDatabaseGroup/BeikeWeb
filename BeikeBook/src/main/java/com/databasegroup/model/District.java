package com.databasegroup.model;

public class District {
	private int districtID;
	private String districtName;
	private int districtNum;
	private String address;
	private String deliverName;
	private String deliverPhone;
	private int schoolID;
	
	@Override
	public String toString() {
		return "" + districtID + ' ' + districtName + ' ' + districtNum + ' ' +
				address + ' ' + deliverName + ' ' + deliverPhone + ' ' + schoolID;
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
	 * @return the districtNum
	 */
	public int getDistrictNum() {
		return districtNum;
	}
	/**
	 * @param districtNum the districtNum to set
	 */
	public void setDistrictNum(int districtNum) {
		this.districtNum = districtNum;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the deliverName
	 */
	public String getDeliverName() {
		return deliverName;
	}
	/**
	 * @param deliverName the deliverName to set
	 */
	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}
	/**
	 * @return the deliverPhone
	 */
	public String getDeliverPhone() {
		return deliverPhone;
	}
	/**
	 * @param deliverPhone the deliverPhone to set
	 */
	public void setDeliverPhone(String deliverPhone) {
		this.deliverPhone = deliverPhone;
	}
	/**
	 * @return the schoolID
	 */
	public int getSchoolID() {
		return schoolID;
	}
	/**
	 * @param schoolID the schoolID to set
	 */
	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}
	
	
}
