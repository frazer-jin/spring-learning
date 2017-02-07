package com.relay2.beans;

public class HelloWorld {
	
	private HelloWorld() {
		super();
	}

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void say(){
		System.out.println("Hello world, " + name);
	}
}
