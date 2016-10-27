package com.databasegroup.model;

public class Book {
	private int id;
	private int bookCategoryId;
	private String title;
	private String coverPath;
	private int deliveryMethodId;
	private String press;
	private String author;
	private String edition;
	private double sellingPrice;
	private double rentalPrice;
	
	@Override
	public String toString() {
		return "" + id + ' ' + bookCategoryId + ' ' + title + ' ' +
				coverPath + ' ' + deliveryMethodId + ' ' + press + ' ' +
				author + ' ' + edition + ' ' + sellingPrice + ' ' + rentalPrice;
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
	 * @return the bookCategoryId
	 */
	public int getBookCategoryId() {
		return bookCategoryId;
	}

	/**
	 * @param bookCategoryId the bookCategoryId to set
	 */
	public void setBookCategoryId(int bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
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
	 * @return the deliveryMethodId
	 */
	public int getDeliveryMethodId() {
		return deliveryMethodId;
	}

	/**
	 * @param deliveryMethodId the deliveryMethodId to set
	 */
	public void setDeliveryMethodId(int deliveryMethodId) {
		this.deliveryMethodId = deliveryMethodId;
	}

	/**
	 * @return the press
	 */
	public String getPress() {
		return press;
	}

	/**
	 * @param press the press to set
	 */
	public void setPress(String press) {
		this.press = press;
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
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * @param edition the edition to set
	 */
	public void setEdition(String edition) {
		this.edition = edition;
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
	 * @return the rentalPrice
	 */
	public double getRentalPrice() {
		return rentalPrice;
	}

	/**
	 * @param rentalPrice the rentalPrice to set
	 */
	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	
}
