package com.databasegroup.model;

public class SellingOrder extends Order {
	
	private int payed;
	private int took;

	@Override
	public String toString() {
		return "[" + id + ' ' + userId + ' ' + deliveryMethodId + ' '
				+ dealedBooks + ' ' + amount + ' ' + datetime + ' ' +
				takingBookNum + ' ' + isRenting + ' ' + payed + ']';
	}

	/**
	 * @return the payed
	 */
	public int getPayed() {
		return payed;
	}

	/**
	 * @param payed the payed to set
	 */
	public void setPayed(int payed) {
		this.payed = payed;
	}
	
	public int getTook() {
		return took;
	}
	
	public void setTook(int took) {
		this.took = took;
	}
	
}
