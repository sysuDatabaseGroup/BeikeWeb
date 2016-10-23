package com.databasegroup.model;

public class Announ {
	private int announID;
	private String announContent;
	
	@Override
	public String toString() {
		return "" + announID + ' ' + announContent;
	}
	
	/**
	 * @return the announID
	 */
	public int getAnnounID() {
		return announID;
	}
	/**
	 * @param announID the announID to set
	 */
	public void setAnnounID(int announID) {
		this.announID = announID;
	}
	/**
	 * @return the annountContent
	 */
	public String getAnnounContent() {
		return announContent;
	}
	/**
	 * @param annountContent the annountContent to set
	 */
	public void setAnnounContent(String announContent) {
		this.announContent = announContent;
	}
}
