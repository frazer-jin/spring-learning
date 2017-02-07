package com.relay2.tx;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
//	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private void init(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int create(User user){
		String sql = "insert into user(first_name, last_name, email, birth) values(?,?,?,?)";
		
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(sql, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DATE);
		
		PreparedStatementCreator psc = pscf.newPreparedStatementCreator(new Object[]{user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirth()});
		pscf.setReturnGeneratedKeys(true);
		
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(psc, generatedKeyHolder);
		return generatedKeyHolder.getKey().intValue();
	}
	
	public void update(User user){
		String sql = "update user set first_name = ?, last_name = ?, email = ?, birth = ? where id = ?";
		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirth(), user.getId());
	}
	
	public User get(int id){
		String sql = "select id, first_name firstName, last_name lastName, email, birth from user where id = ?";
		
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		
		User user = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return user;
		
	}
	
	public void delete(int id){
		String sql = "delete from user where id = ?";
		jdbcTemplate.update(sql, id);
	}
}
