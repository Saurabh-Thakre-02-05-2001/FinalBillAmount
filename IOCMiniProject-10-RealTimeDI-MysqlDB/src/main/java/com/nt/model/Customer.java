package com.nt.model;

public class Customer {
	private int customer_number;
	private String customer_name;
	private String customer_address;
	private double bill_amount;
	private double discount;
	private double final_amount;
	
	//getter and setter
	public int getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(int customer_number) {
		this.customer_number=customer_number;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public double getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(double bill_amount) {
		this.bill_amount = bill_amount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getFinal_amount() {
		return final_amount;
	}
	public void setFinal_amount(double final_amount) {
		this.final_amount = final_amount;
	}
	

}
