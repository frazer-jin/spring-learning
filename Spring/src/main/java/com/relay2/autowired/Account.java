package com.relay2.autowired;

import org.springframework.stereotype.Component;

@Component
public class Account {

	private String type = "save card";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [type=" + type + "]";
	}
	
	
}
