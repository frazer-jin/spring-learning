package com.relay2.java.annotation;

import org.springframework.stereotype.Component;

@Component
public class UserProfile {

	private int id;
	
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", description=" + description + "]";
	}
	
}
