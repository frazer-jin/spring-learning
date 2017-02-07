package com.relay2.jdbc;

import java.sql.Connection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class SpringJdbcPool {

	public static void main(String[] args) throws Exception {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ComboPooledDataSource dataSource = (ComboPooledDataSource) ctx.getBean("dataSource");
		
		Connection conn = dataSource.getConnection();
		
		System.out.println(dataSource);
		System.out.println(conn);
		
		Thread.sleep(20000);
		
		System.out.println(dataSource.getNumConnections());
		
		JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		
		SqlRowSet rowSet = template.queryForRowSet("select priority, calendar_name, (select sum(priority) from qrtz_triggers where calendar_name='') from qrtz_triggers where sched_name='Relay2 Scheduler'");
		while(rowSet.next()){
			System.out.println(rowSet.getInt(1));
			System.out.println(rowSet.getString(2));
			System.out.println(rowSet.getInt(3));
		}
		
	}
	
}
