package com.databasegroup.model;

import java.util.Date;

public class Banner {
	private int bannerID;
	private String bannerPic;
	private String bannerTitle;
	private String link;
	private Date datetime;
	private int prior;
	
	@Override
	public String toString() {
		return "" + bannerID + ' ' + bannerPic + ' ' + bannerTitle + ' ' +
				link + ' ' + datetime + ' ' + prior;
	}
	
	/**
	 * @return the bannerID
	 */
	public int getBannerID() {
		return bannerID;
	}
	/**
	 * @param bannerID the bannerID to set
	 */
	public void setBannerID(int bannerID) {
		this.bannerID = bannerID;
	}
	/**
	 * @return the bannerPic
	 */
	public String getBannerPic() {
		return bannerPic;
	}
	/**
	 * @param bannerPic the bannerPic to set
	 */
	public void setBannerPic(String bannerPic) {
		this.bannerPic = bannerPic;
	}
	/**
	 * @return the bannerTitle
	 */
	public String getBannerTitle() {
		return bannerTitle;
	}
	/**
	 * @param bannerTitle the bannerTitle to set
	 */
	public void setBannerTitle(String bannerTitle) {
		this.bannerTitle = bannerTitle;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
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
	 * @return the prior
	 */
	public int getPrior() {
		return prior;
	}
	/**
	 * @param prior the prior to set
	 */
	public void setPrior(int prior) {
		this.prior = prior;
	}
}
