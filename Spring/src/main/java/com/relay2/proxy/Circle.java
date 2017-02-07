package com.relay2.proxy;

public class Circle implements Sharp {

	@Override
	public void draw() {
		System.out.println("draw circle...");
	}

	@Override
	public int size() {
		return 100;
	}

}
