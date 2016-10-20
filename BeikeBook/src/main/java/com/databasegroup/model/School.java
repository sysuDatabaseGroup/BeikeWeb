package com.databasegroup.model;

public class School {
	private int schoolID;
	private String schoolName;
	private String schoolNum;
	private String schoolAdmin;
	private String schoolPassword;
	private int cityID;
	
	@Override
	public String toString() {
		return "" + schoolID + ' ' + schoolName + ' ' + schoolNum + ' ' +
				schoolAdmin + ' ' + schoolPassword + ' ' + cityID;
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
	 * @return the schoolNum
	 */
	public String getSchoolNum() {
		return schoolNum;
	}
	/**
	 * @param schoolNum the schoolNum to set
	 */
	public void setSchoolNum(String schoolNum) {
		this.schoolNum = schoolNum;
	}
	/**
	 * @return the schoolAdmin
	 */
	public String getSchoolAdmin() {
		return schoolAdmin;
	}
	/**
	 * @param schoolAdmin the schoolAdmin to set
	 */
	public void setSchoolAdmin(String schoolAdmin) {
		this.schoolAdmin = schoolAdmin;
	}
	/**
	 * @return the schoolPassword
	 */
	public String getSchoolPassword() {
		return schoolPassword;
	}
	/**
	 * @param schoolPassword the schoolPassword to set
	 */
	public void setSchoolPassword(String schoolPassword) {
		this.schoolPassword = schoolPassword;
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
	
}
