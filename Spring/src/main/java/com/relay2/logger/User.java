package com.relay2.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
	
	private static Logger logger = LoggerFactory.getLogger(User.class.getSimpleName());
	
	public User(){
		logger.info("new user...");
	}
}
