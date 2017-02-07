package com.relay2.system.property;

import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		Properties properties = System.getProperties();
		System.setProperty("xxx", "yyy");
		for(Object key : properties.keySet()){
			System.out.println("System's properties key: " + key + ",\t\t value: " + properties.getProperty((String)key));	
		}
	}

}
