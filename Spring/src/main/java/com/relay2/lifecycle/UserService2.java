package com.relay2.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("userService22")
public class UserService2 {

	
	public void create(){
		System.out.println("create method invoke...");
	}
	
	
	@PostConstruct()
	private void init(){
		System.out.println("init method invoke..." + this.getClass().getCanonicalName());
	}
	
	@PreDestroy
	private void destory(){
		System.out.println("destory method invoke..." + this.getClass().getCanonicalName());
	}
}
