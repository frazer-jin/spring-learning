package com.relay2.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-spel.xml");
		
		User user = (User) ctx.getBean("user");
		
		System.out.println(user);
		
		ExpressionParser parser = new SpelExpressionParser();
		
		Expression exp = parser.parseExpression("'hello world'");
		String value = (String) exp.getValue();
		System.out.println(value);
		
	}
	
}
