package com.databasegroup.model;

public class User {
	private int id;
	private String wxPhoto;
	private String wxName;
	private String userNum;
	private String password;
	private City city;
	private School school;
	private int cityId;
	private int schoolId;
	private String dorm;
	
	@Override
	public String toString() {
		return "[" + id + ' ' + wxPhoto + ' ' + wxName + ' ' +
				userNum + ' ' + password + ' ' + city + ' ' + 
				school + ' ' + dorm + ']';
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
	 * @return the wxPhoto
	 */
	public String getWxPhoto() {
		return wxPhoto;
	}

	/**
	 * @param wxPhoto the wxPhoto to set
	 */
	public void setWxPhoto(String wxPhoto) {
		this.wxPhoto = wxPhoto;
	}

	/**
	 * @return the wxName
	 */
	public String getWxName() {
		return wxName;
	}

	/**
	 * @param wxName the wxName to set
	 */
	public void setWxName(String wxName) {
		this.wxName = wxName;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(School school) {
		this.school = school;
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

	/**
	 * @return the cityId
	 */
	public int getCityId() {
		return cityId;
	}

	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the schoolId
	 */
	public int getSchoolId() {
		return schoolId;
	}

	/**
	 * @param schoolId the schoolId to set
	 */
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	
	
}
