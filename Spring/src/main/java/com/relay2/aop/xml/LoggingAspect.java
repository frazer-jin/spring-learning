package com.relay2.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {
	
	
	public void declareJoinPointExpression(){/* empty content */};


	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("The method: " + methodName + " begin, with parameter: " + Arrays.asList(args));
	}
	
	public void afterMethod(JoinPoint joinPoint){
		System.out.println("The method end.");
	}
	
	public void afterRunning(JoinPoint joinPoint, Object result){
		System.out.println("The method return. result: " + result);
	}
	
	public void afterThrowing(JoinPoint joinPoint){
		System.out.println("The method exception.");
	}
	
	/*
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result = null;
		String methodName = pjd.getSignature().getName();
		
		try {
			// before method
			System.out.println("The method: " + methodName + ", with: " + Arrays.asList(pjd.getArgs()));
			result = pjd.proceed();
			// return method
			System.out.println("The method: " + methodName + ", return: " + result);
			
		} catch (Throwable e) {
			e.printStackTrace();
			// throwing method
			System.out.println("The method: " + methodName + ", throwing: " + e);
		}
		//end method
		System.out.println("The method: " + methodName + " end.");
		return result;
	}
	*/
	
}
