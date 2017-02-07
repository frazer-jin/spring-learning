package com.relay2.beans;

public class UserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User createUser(User user) {
		System.out.println("Service create user...");
		User user1 = userDao.createUser();
		user1.setName("Lucy");
		return user1;
	}
	
}
