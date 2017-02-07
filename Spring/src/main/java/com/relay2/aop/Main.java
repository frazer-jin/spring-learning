package com.relay2.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-aop.xml");
		
		Shape circle = (Shape) ctx.getBean("circle");
		
		circle.draw(100);
		
		circle.size();
		
	}
	
}
