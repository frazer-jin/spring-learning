package com.relay2.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-aop-xml.xml");
		
		Shape circle = (Shape) ctx.getBean("circle3");
		
		circle.draw(100);
		
		circle.size();
		
	}
	
}
