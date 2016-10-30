package com.databasegroup.model;

import java.util.Date;

public class RentingOrder extends Order {
	
	private int took;
	private int returned;
	
	@Override
	public String toString() {
		return "[" + id + ' ' + userId + ' ' + deliveryMethodId + ' '
				+ dealedBooks + ' ' + amount + ' ' + datetime + ' ' +
				takingBookNum + ' ' + took + ' ' + returned + ' ' +
				isRenting + ']';
	}
	

	/**
	 * @return the took
	 */
	public int getTook() {
		return took;
	}

	/**
	 * @param took the took to set
	 */
	public void setTook(int took) {
		this.took = took;
	}

	/**
	 * @return the returned
	 */
	public int getReturned() {
		return returned;
	}

	/**
	 * @param returned the returned to set
	 */
	public void setReturned(int returned) {
		this.returned = returned;
	}
}
