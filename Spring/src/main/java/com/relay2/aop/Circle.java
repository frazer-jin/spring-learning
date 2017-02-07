package com.relay2.aop;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {

	@Override
	public void draw(int i) {
		System.out.println("draw circle...");
	}

	@Override
	public int size() {
		System.out.println("size circle...");
		//throw new RuntimeException("");
		return 100;
	}

}
