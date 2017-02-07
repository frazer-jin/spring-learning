package com.relay2.jdbc;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Connection {

	public static void main(String[] args) throws Exception {
		
		method1();
		
	}
	
	public static void method1() throws Exception{
		// automatically load properties from c3p0.properties file on classpath
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		Connection conn = dataSource.getConnection();
		
		System.out.println(dataSource);
		System.out.println(conn);
		Thread.sleep(25000);
		System.out.println(dataSource.getNumConnections());
		
	}
	
}
