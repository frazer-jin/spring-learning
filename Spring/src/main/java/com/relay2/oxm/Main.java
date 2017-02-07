package com.relay2.oxm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
	
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-oxm.xml");
		
		Service service = (Service) ctx.getBean("service");
		
		User user = new User();
		user.setAge(19);
		user.setName("Tom");
		user.setBirth(new Date());
		System.out.println("saved user:" + user);
		service.saveUser(user);
		
		user = service.loadUser();
		System.out.println("loaded user:" + user);
		
		List<User> users = new ArrayList<>();
		User user1 = new User();
		user1.setAge(19);
		user1.setName("Tom");
		user1.setBirth(new Date());
		System.out.println("saved user:" + user1);
		users.add(user1);
		User user2 = new User();
		user2.setAge(22);
		user2.setName("Lucy");
		user2.setBirth(new Date());
		System.out.println("saved user:" + user2);
		users.add(user2);
		
		service.saveUsers(users);
		
		users = service.loadUsers();
		System.out.println("loaded users:" + users);
		
		
	}
	
}
