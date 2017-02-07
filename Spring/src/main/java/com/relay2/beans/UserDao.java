package com.relay2.beans;

public class UserDao {

	public User createUser() {
		return new User();
	}

	public void updateUser(User user) {
		System.out.println("Update user.");
	}

	public void deleteUser(Long userId) {
		System.out.println("Delete user: " + userId);
	}

	public User findUser(Long userId) {
		User user = new User();
		user.setName("Jack");
		user.setAge(18);
		return user;
	}
}
