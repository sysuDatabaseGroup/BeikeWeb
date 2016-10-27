package com.databasegroup.model;

public class District {
	private int id;
	private String name;
	private int num;
	private String address;
	private String deliverName;
	private String deliverPhone;
	private int schoolId;
	
	@Override
	public String toString() {
		return "[" + id + ' ' + name + ' ' + num + ' ' + address + ' ' 
				+ deliverName + ' ' + deliverPhone + ' ' + 
				schoolId + ']';
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
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
