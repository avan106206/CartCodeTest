package com.CartModel;

import java.util.ArrayList;

public class Receipt extends Item {
	double subtotal;
	
	double totaltax;
	
	double total;
	
	ArrayList <Item> itemlist;

	/**Getter and Setter**/
	

	public double getTotaltax() {
		return totaltax;
	}

	public void setTotaltax(double totaltax) {
		this.totaltax = totaltax;
	}

	public ArrayList<Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(ArrayList<Item> itemlist) {
		this.itemlist = itemlist;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


	
	
}
