package com.relay2.email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-mail.xml");
		
//		OrderManager manager = (OrderManager) ctx.getBean("orderManager");
//		
//		Order order = new Order();
//		order.setFirstName("Jim");
//		order.setLastName("Green");
//		order.setMail("minfei.jin@relay2.com");
//		order.setOrder(99);
//		
//		manager.placeOrder(order);
//		
//		OrderManager manager2 = (OrderManager) ctx.getBean("orderManager2");
//		
//		order = new Order();
//		order.setFirstName("Tom");
//		order.setLastName("Cat");
//		order.setMail("minfei.jin@relay2.com");
//		order.setOrder(100);
//		
//		manager2.placeOrder(order);
		
//		OrderManager manager3 = (OrderManager) ctx.getBean("orderManager3");
//		
//		Order order = new Order();
//		order.setFirstName("Tom");
//		order.setLastName("Cat");
//		order.setMail("minfei.jin@relay2.com");
//		order.setOrder(111);
//		
//		manager3.placeOrder(order);
		
//		OrderManager manager4 = (OrderManager) ctx.getBean("orderManager4");
//		
//		Order order = new Order();
//		order.setFirstName("Tom");
//		order.setLastName("Cat");
//		order.setMail("minfei.jin@relay2.com");
//		order.setOrder(222);
//		
//		manager4.placeOrder(order);
		
		OrderManager manager5 = (OrderManager) ctx.getBean("orderManager5");
		
		Order order = new Order();
		order.setFirstName("Tom");
		order.setLastName("Cat");
		order.setMail("minfei.jin@relay2.com");
		order.setOrder(222);
		
		manager5.placeOrder(order);
	}
	
}
