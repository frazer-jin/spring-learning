package com.relay2.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-autowired.xml");
		
		User user = (User) ctx.getBean("user");
		
		System.out.println(user);
		
	}
	
}
