package com.databasegroup.model;

public class BookClass {
	private int bookClassID;
	private int classID;
	private String bookClassName;
	private String bookClassImg;
	private int methodID;
	private String company;
	private String author;
	private String version;
	private double sellPrice;
	private double borrowPrice;
	
	@Override
	public String toString() {
		return "" + bookClassID + ' ' + classID + ' ' + bookClassName + ' ' +
				bookClassImg + ' ' + methodID + ' ' + company + ' ' +
				author + ' ' + version + ' ' + sellPrice + ' ' + borrowPrice;
	}
	
	/**
	 * @return the bookClassID
	 */
	public int getBookClassID() {
		return bookClassID;
	}
	/**
	 * @param bookClassID the bookClassID to set
	 */
	public void setBookClassID(int bookClassID) {
		this.bookClassID = bookClassID;
	}
	/**
	 * @return the classID
	 */
	public int getClassID() {
		return classID;
	}
	/**
	 * @param classID the classID to set
	 */
	public void setClassID(int classID) {
		this.classID = classID;
	}
	/**
	 * @return the bookClassName
	 */
	public String getBookClassName() {
		return bookClassName;
	}
	/**
	 * @param bookClassName the bookClassName to set
	 */
	public void setBookClassName(String bookClassName) {
		this.bookClassName = bookClassName;
	}
	/**
	 * @return the bookClassImg
	 */
	public String getBookClassImg() {
		return bookClassImg;
	}
	/**
	 * @param bookClassImg the bookClassImg to set
	 */
	public void setBookClassImg(String bookClassImg) {
		this.bookClassImg = bookClassImg;
	}
	/**
	 * @return the methodID
	 */
	public int getMethodID() {
		return methodID;
	}
	/**
	 * @param methodID the methodID to set
	 */
	public void setMethodID(int methodID) {
		this.methodID = methodID;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the sellPrice
	 */
	public double getSellPrice() {
		return sellPrice;
	}
	/**
	 * @param sellPrice the sellPrice to set
	 */
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	/**
	 * @return the borrowPrice
	 */
	public double getBorrowPrice() {
		return borrowPrice;
	}
	/**
	 * @param borrowPrice the borrowPrice to set
	 */
	public void setBorrowPrice(double borrowPrice) {
		this.borrowPrice = borrowPrice;
	}
	
	
}
