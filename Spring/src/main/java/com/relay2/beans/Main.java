package com.relay2.beans;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		
		helloWorld.say();

		UserDao userDao = ctx.getBean(UserDao.class);
		
		System.out.println(userDao);
		
		UserService userService = (UserService) ctx.getBean("userService");
		
		userService.createUser(new User());
		
		UserService userService2 = (UserService) ctx.getBean("userService2");
		
		userService2.createUser(new User());
		
		ExampleBean exampleBean = (ExampleBean) ctx.getBean("exampleBean");
		
		System.out.println(exampleBean);
		
		ExampleBean exampleBean1 = (ExampleBean) ctx.getBean("exampleBean1");
		
		System.out.println(exampleBean1);
		
		ExampleBean exampleBean2 = (ExampleBean) ctx.getBean("exampleBean2");
		
		System.out.println(exampleBean2);
		
		ctx.close();
	}
	
}
