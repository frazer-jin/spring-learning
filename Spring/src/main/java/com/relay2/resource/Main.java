package com.relay2.resource;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ResourceUtils;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Loader loader = new Loader();
		//File file = ResourceUtils.getFile("classpath:db.properties");
		//File file = ResourceUtils.getFile("file:D:\\workspace\\maven\\src\\main\\resources\\db.properties");
		File file = ResourceUtils.getFile("D:\\workspace\\maven\\src\\main\\resources\\db.properties");
		//File file = ResourceUtils.getFile("jar:ch.qos.logback.classic.db.script.db2.sql");
		System.out.println(file.exists());
		Properties properties = new Properties();
		properties.load(new FileInputStream(file));
		loader.setDb(properties);
		System.out.println(loader);

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-resource.xml");
		
		MyResource resource = (MyResource) ctx.getBean("myResource");
		
		resource.print();
	}

}
