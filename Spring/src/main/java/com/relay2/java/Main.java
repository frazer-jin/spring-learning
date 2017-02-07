package com.relay2.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.relay2.java.annotation.UserProfile;

public class Main {

	public static void main(String[] args) {
		
		/* method1 */
		/*ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);*/
		
		/* method2 */
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		//ctx.register(AppConfig.class);
		ctx.scan("com.relay2.java");
		ctx.refresh();
		
		Account account = (Account) ctx.getBean("account");
		
		System.out.println(account);
		
		User user = (User) ctx.getBean("user");
		
		System.out.println(user);
		
		UserProfile userProfile = (UserProfile) ctx.getBean("userProfile");
		
		System.out.println(userProfile);
		
		ctx.registerShutdownHook();
	}
	
}
