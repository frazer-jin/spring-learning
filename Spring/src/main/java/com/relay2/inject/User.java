package com.relay2.inject;

public abstract class User {

	private String name;
	
	private Account account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return createAccount();
	}
	
	protected abstract Account createAccount();

	@Override
	public String toString() {
		return "User [name=" + name + ", account=" + getAccount() + "]";
	}
	
	
}
