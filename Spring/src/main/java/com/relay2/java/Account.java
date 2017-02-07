package com.relay2.java;

public class Account {

	private String type;
	
	private double balance;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [type=" + type + ", balance=" + balance + "]";
	}
	
	
}
