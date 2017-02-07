package com.relay2.message;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
		
		MessageSource ms = new ClassPathXmlApplicationContext("application-message.xml");
		
		String message = ms.getMessage("message.hello", null, Locale.ENGLISH);
		
		System.out.println(message);
		
		int i=10;
		
		while(i>0){
			i--;
			message = ms.getMessage("message.test", new Object[]{"tom"}, Locale.CHINA);
			
			System.out.println(message);
			
			message = ms.getMessage("message.hello", null, Locale.CHINA);
//			Thread.sleep(2000);
		}
		
	}
	
}
