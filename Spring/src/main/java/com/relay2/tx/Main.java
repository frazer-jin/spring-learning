package com.relay2.tx;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-tx.xml");
		
		UserService service = (UserService) ctx.getBean("userService");
		
		System.out.println(service);
		
		// insert one
		User user = new User("Jame", "Smith", "js@relay2.com", new Date(System.currentTimeMillis()));
		int id = service.createUser(user);
		
		//query one
		user = service.getUser(id);
		System.out.println(user);
		
		// update one
		user.setFirstName("Kate");
		service.updateUser(user);
		
		user = service.getUser(id);
		System.out.println("Changed user: " + user);
		
		// delete one
		service.deleteUser(id);
		
//		user = service.getUser(id);
//		System.out.println("user with Id: " + id + ": " + user);
		
		List<User> users = new ArrayList<>();
		for(int i=0; i<10; i++){
			User s = new User("f-"+i, "l-"+i, "fl-"+i+"@relay2.com", new Date(System.currentTimeMillis()));
			users.add(s);
		}
		//users.add(new User("long name....................................................", "lastName", "email@relay2.com", null));
		service.createUsers(users.toArray(new User[]{}));
	}
}
