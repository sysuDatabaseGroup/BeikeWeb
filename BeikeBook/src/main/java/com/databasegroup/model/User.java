package com.databasegroup.model;

public class User {
	private int userID;
	private String wx_photo;
	private String wx_name;
	private String userNum;
	private int cityID;
	private int schoolID;
	private String dorm;
	
	@Override
	public String toString() {
		return "" + userID + ' ' + wx_photo + ' ' + wx_name + ' ' +
				userNum + ' ' + cityID + ' ' + schoolID + ' ' + dorm;
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
	 * @return the wx_photo
	 */
	public String getWx_photo() {
		return wx_photo;
	}
	/**
	 * @param wx_photo the wx_photo to set
	 */
	public void setWx_photo(String wx_photo) {
		this.wx_photo = wx_photo;
	}
	/**
	 * @return the wx_name
	 */
	public String getWx_name() {
		return wx_name;
	}
	/**
	 * @param wx_name the wx_name to set
	 */
	public void setWx_name(String wx_name) {
		this.wx_name = wx_name;
	}
	/**
	 * @return the userNum
	 */
	public String getUserNum() {
		return userNum;
	}
	/**
	 * @param userNum the userNum to set
	 */
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	/**
	 * @return the cityID
	 */
	public int getCityID() {
		return cityID;
	}
	/**
	 * @param cityID the cityID to set
	 */
	public void setCityID(int cityID) {
		this.cityID = cityID;
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
	/**
	 * @return the dorm
	 */
	public String getDorm() {
		return dorm;
	}
	/**
	 * @param dorm the dorm to set
	 */
	public void setDorm(String dorm) {
		this.dorm = dorm;
	}
	
}
