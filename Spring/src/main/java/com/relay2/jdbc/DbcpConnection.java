package com.relay2.jdbc;

import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DbcpConnection {

	public static void main(String[] args) throws Exception {
		
		method1();
		
	}
	
	
	public static void method1() throws Exception{
		
		BasicDataSource dataSource = null;
		
		Properties properties = new Properties();
		properties.load(DbcpConnection.class.getResourceAsStream("/dbcp.properties"));
		
		String url = properties.getProperty("dbcp.url");
		String driverClassName = properties.getProperty("dbcp.driverClassName");
		String username = properties.getProperty("dbcp.username");
		String password = properties.getProperty("dbcp.password");
		String minIdle = properties.getProperty("dbcp.minIdle");
		String maxIdle = properties.getProperty("dbcp.maxIdle");
		String maxWait = properties.getProperty("dbcp.maxWait");
		String maxActive = properties.getProperty("dbcp.maxActive");
		
		dataSource = new BasicDataSource();
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setMinIdle(Integer.parseInt(minIdle));
		dataSource.setMaxIdle(Integer.parseInt(maxIdle));
		dataSource.setMaxWait(Integer.parseInt(maxWait));
		dataSource.setMaxActive(Integer.parseInt(maxActive));
		
		Connection conn = dataSource.getConnection();
		
		System.out.println(dataSource);
		System.out.println(conn);
		
		System.out.println(dataSource.getNumActive());
		
	}
}
