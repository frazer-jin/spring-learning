package com.relay2.dubbo;

import java.util.ArrayList;
import java.util.List;

public class DemoUserServiceImpl implements DemoService {

	@Override
	public String sayHello(String name) {
		return "Hello: " + name;
	}

	@Override
	public List<User> getUsers() {
		List<User> list = new ArrayList<>();
		
		User u1 = new User("jack", 21, false);
		User u2 = new User("kate", 18, true);
		User u3 = new User("Marry", 19, true);
		
		list.add(u1);
		list.add(u2);
		list.add(u3);
		
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
