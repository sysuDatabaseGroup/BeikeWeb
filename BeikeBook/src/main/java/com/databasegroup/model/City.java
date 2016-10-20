package com.databasegroup.model;

public class City {
	private int cityID;
	private String cityName;
	private String cityNum;
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
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the cityNum
	 */
	public String getCityNum() {
		return cityNum;
	}
	/**
	 * @param cityNum the cityNum to set
	 */
	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return cityName + ' ' + cityNum;
	}
}
