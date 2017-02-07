package com.relay2.embedded;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-embedded.xml");
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		
		System.out.println(dataSource);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "select id, name, birth from user";
		
		ColumnMapRowMapper rowMapper = new ColumnMapRowMapper(){
			@Override
			public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Date birth = rs.getDate(3);
				Map<String, Object> map = new HashMap<>();
				map.put("id", id);
				map.put("name", name);
				map.put("birth", birth);
				return map;
			}
		};
		
		List<Map<String, Object>> query = jdbcTemplate.query(sql, rowMapper);
		System.out.println(query);
	}
	
}
