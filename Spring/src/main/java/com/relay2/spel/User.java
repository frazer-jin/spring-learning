package com.relay2.spel;

import org.springframework.beans.factory.annotation.Value;

public class User {

	@Value("#{ systemProperties['user.home'] }")
	private String name;
	
	@Value("#{ T(java.lang.Math).random() * 100.0 }")
	private int random;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", random=" + random + "]";
	}

	
}
