package com.relay2.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@ComponentScan("com.relay2.java.annotation")
@Configuration
public class AppConfig {

	@Bean
	public Account account(){
		Account account = new Account();
		account.setType("Save card");
		account.setBalance(100.0);
		
		return account;
	}
	
	@Bean
	public User user(){
		User user = new User();
		user.setName("Jack");
		user.setAge(18);
		user.setAccount(account());
		return user;
	}
}
