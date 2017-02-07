package com.relay2.inject;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("application-inject.xml");
		
		User user = (User) ctx.getBean("user");
		
		System.out.println(user);
		
		Thread.sleep(1000);
		
		user = (User) ctx.getBean("user");
		
		System.out.println(user);
		
		ctx.registerShutdownHook();
		
		ctx.close();
	}
	
}
