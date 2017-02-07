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

	public int create(User user) throws Exception{
		
		// 有意产生异常
		// 产生运行期异常（非检测异常）的测试
		if(user.getFirstName().equals("运行期异常")){
			throw new RuntimeException("runtime exception...");
		}
		
		// 产生非运行期异常（检测异常）的测试
		if(user.getFirstName().equals("非运行期异常")){
			throw new Exception("not runtime exception...");
		}
		// 结论： 默认地，事务只有在抛出运行期异常的情况下才会回滚，如果期望改变这一默认行为，需要在@Transactional 标签上加上
		// rollbackFor=XXXException.class 这一属性
		// 如果 被 @Transactional 包裹的方法 try -- catch 了所有的异常而并没有往外抛异常，这程序认为执行正常，不会回滚事务。
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
