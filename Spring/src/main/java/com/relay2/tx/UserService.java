package com.relay2.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TransactionTemplate transactionTemplate;

	public int createUser(User user){
		return userDao.create(user);
	}
	
	public void createUsers(final User... users){
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				for(User user : users){
					userDao.create(user);
				}
			}
		});
	}
	
	public void updateUser(User user){
		userDao.update(user);
	}
	
	public User getUser(int id){
		return userDao.get(id);
	}
	
	public void deleteUser(int id){
		userDao.delete(id);
	}
}
