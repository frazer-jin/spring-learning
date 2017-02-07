package com.relay2.tx;

import java.sql.Date;

public class User {
	
	

	public User(String firstName, String lastName, String email, Date birth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birth = birth;
	}

	public User() {
		super();
	}

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Date birth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", birth=" + birth + "]";
	}
	
}
