package com.relay2.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JdbcConnection {

	public static void main(String[] args) throws Exception {
//		method1();
//		method2();
		Connection conn = method3();
		
		String sql = "select a, b from t1";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
		    String column1 = rs.getString(1);
		    String column2 = rs.getString(2);
		    System.out.println(column1 + " : " + (null == column2 ? "" : Integer.parseInt(column2)));
		}
		
	}
	
	// Load from property file
	public static Connection method3() throws Exception{
		Connection conn = null;
		InputStream in = JdbcConnection.class.getResourceAsStream("/db.properties");
		
		Properties info = new Properties();
		info.load(in);
		
		String url = info.getProperty("db.url");
		String driverClass = info.getProperty("db.driverClass");
		String user = info.getProperty("db.user");
		String password = info.getProperty("db.password");
		
		Class.forName(driverClass);
		
		conn = DriverManager.getConnection(url, user, password);
		
		return conn;
		
	}
	
	// with DriverManager
	public static void method2() throws Exception{
		Connection conn = null;
		
		// Load driver
		//Class.forName("com.mysql.jdbc.Driver");
		// get connection from DriverManager
		String url = "jdbc:mysql:///test";
		String user = "root";
		String password = "mysql";
		conn = DriverManager.getConnection(url, user, password);
		
		System.out.println(conn);
	}
	
	// new instance of driver
	public static void method1() throws Exception{
		Connection conn = null;
		
		//driver
		Driver driver = new com.mysql.jdbc.Driver();
		//url
		String url = "jdbc:mysql:///test";
		String user = "root";
		String password = "mysql";
		
		Properties info = new Properties();
		info.put("user", user);
		info.put("password", password);
		
		conn = driver.connect(url, info);
		
		System.out.println(conn);

	}
}
