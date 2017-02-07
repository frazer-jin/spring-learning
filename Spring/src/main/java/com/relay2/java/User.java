package com.relay2.java;

public class User {

	private String name;
	
	private int age;
	
	private Account account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", account=" + account + "]";
	}
	
}
