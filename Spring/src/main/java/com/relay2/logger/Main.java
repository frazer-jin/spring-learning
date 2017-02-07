package com.relay2.logger;

import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

public class Main {

	public static void main(String[] args) {
		User.class.getName();
		
		LoggerContext ctx = (LoggerContext) LoggerFactory.getILoggerFactory();
		List<Logger> loggerList = ctx.getLoggerList();
		for(Logger logger : loggerList){
			System.out.println(logger.getName() + ":" + logger.getLevel());
		}
		User user = new User();
		
		loggerList = ctx.getLoggerList();
		for(Logger logger : loggerList){
			System.out.println(logger.getName() + ":" + logger.getLevel());
		}
	}
	
}
