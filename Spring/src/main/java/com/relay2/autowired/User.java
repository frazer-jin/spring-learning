package com.relay2.autowired;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class User {

	private String name;
	
	private Account account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	@Inject()
	@Required
//	@Autowired
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", account=" + account + "]";
	}
	
	
}
