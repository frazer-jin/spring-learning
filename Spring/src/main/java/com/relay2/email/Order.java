package com.relay2.email;

public class Order {

	private String mail;
	
	private String firstName;
	
	private String lastName;
	
	private int order;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Order [mail=" + mail + ", firstName=" + firstName + ", lastName=" + lastName + ", order=" + order + "]";
	}
	
}
