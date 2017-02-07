package com.relay2.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-lifecycle.xml");
		
		UserService userService = (UserService) ctx.getBean("userService");
		
		userService.create();
		
		UserService2 userService2 = (UserService2) ctx.getBean("userService22");
		
		userService2.create();
		
		
		ctx.registerShutdownHook();
	}
	
}
