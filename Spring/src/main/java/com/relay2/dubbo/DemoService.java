package com.relay2.dubbo;

import java.util.List;

public interface DemoService {

	String sayHello(String name);
	
	public List<User> getUsers();
}
