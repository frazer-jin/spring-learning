package com.relay2.beans;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest extends AbstractJUnit4SpringContextTests {
	
	

	@Test public void findUserTest(){
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		User user = userDao.findUser(0L);
		Assert.assertNotNull("User is null...", user);
	}
	
	@Test public void deleteUserTest(){
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.deleteUser(0L);
		Assert.assertNotNull(new Object());
	}
	
}
