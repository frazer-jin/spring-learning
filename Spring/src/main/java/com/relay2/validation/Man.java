package com.relay2.validation;

import java.util.Date;

import javax.validation.constraints.Past;

public class Man implements Person {
	
	private String name1;
	private int age;
	
	private Date birth1;

	public String getName() {
		return this.name1;
	}

	public int getAge() {
		return this.age;
	}

	public void setName(String name) {
		this.name1 = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Past()
	public Date getBirth() {
		return birth1;
	}

	public void setBirth(Date birth) {
		this.birth1 = birth;
	}

	@Override
	public String toString() {
		return "Man [name=" + name1 + ", age=" + age + ", birth=" + birth1 + "]";
	}

	
}
