package com.relay2.lifecycle;

public class UserService {

	
	public void create(){
		System.out.println("create method invoke...");
	}
	
	
	public void init(){
		System.out.println("init method invoke..." + this.getClass().getCanonicalName());
	}
}
