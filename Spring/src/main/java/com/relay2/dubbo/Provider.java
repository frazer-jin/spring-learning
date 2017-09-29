package com.relay2.dubbo;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

	public static void main(String[] args) throws IOException {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-dubbo.provider.xml");
		
		//ctx.start();
		
		System.in.read();
	}
}
