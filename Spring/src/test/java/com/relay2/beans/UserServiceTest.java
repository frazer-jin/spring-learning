package com.relay2.beans;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest extends AbstractJUnit4SpringContextTests{

	@Test public void createUserTest() {
		UserDao mock = mock(UserDao.class);
		when(mock.createUser()).thenReturn(new User());
		
		UserService userService = applicationContext.getBean(UserService.class);
		userService.setUserDao(mock);
		// assume the userDao has a bug, and cannot return correct value.
		User user = userService.createUser(new User());
		
		Assert.assertNotNull(user);
		System.out.println(user.getName());
	}
	
}
