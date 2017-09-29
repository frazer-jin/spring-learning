package com.relay2.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-dubbo.consumer.xml");
		ctx.start();
		
		DemoService demoService = (DemoService) ctx.getBean("demoService");
		
		System.out.println(demoService);
		
		while(true) {
			try {
				System.out.println(demoService.sayHello("Jack"));
				
				System.out.println(demoService.getUsers());
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//ctx.close();
	}
}
