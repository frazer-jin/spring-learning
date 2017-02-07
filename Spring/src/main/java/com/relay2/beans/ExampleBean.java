package com.relay2.beans;

public class ExampleBean {

	private int age;
	
	private boolean sex;
	
	private String size;

	private ExampleBean(int age, boolean sex, String size) {
		super();
		this.age = age;
		this.sex = sex;
		this.size = size;
	}

	private ExampleBean(String size, boolean sex, int age) {
		super();
		this.age = age;
		this.sex = sex;
		this.size = size;
	}
	
	private ExampleBean(int age, boolean sex) {
		super();
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "ExampleBean [age=" + age + ", sex=" + sex + ", size=" + size + "]";
	}
	
	
}
