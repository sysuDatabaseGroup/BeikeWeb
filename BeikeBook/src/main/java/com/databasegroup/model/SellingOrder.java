package com.databasegroup.model;

import java.util.Date;

public class SellingOrder extends Order {
	private int payed;

	@Override
	public String toString() {
		return "[" + id + ' ' + userId + ' ' + deliveryMethodId + ' ' +
				dealedBook + ' ' + amount + ' ' + datetime + ' '
				+ ' ' + takingBookNum + ' ' + payed + ' ' + isRenting +
				']';
	}

	/**
	 * @return the payed
	 */
	public int getPayed() {
		return payed;
	}

	/**
	 * @param payed
	 *            the payed to set
	 */
	public void setPayed(int payed) {
		this.payed = payed;
	}

}
