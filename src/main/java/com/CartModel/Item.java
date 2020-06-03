package com.CartModel;

public class Item {
	
	String name;
	
	int qty;
	
	double price;

	String state;
	
	double tax;
	
	double itemtotalprice;

	public double getTax() {
		return tax;
	}

	public void setTax(double d) {
		this.tax = d;
	}

	public double getItemtotalprice() {
		return itemtotalprice;
	}

	public void setItemtotalprice(double itemtotalprice) {
		this.itemtotalprice = itemtotalprice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price2) {
		this.price = price2;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
