package com.relay2.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
	
	
	@Pointcut("execution(public * com.relay2.aop.Circle.*(..))")
	public void declareJoinPointExpression(){/* empty content */};


	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("The method: " + methodName + " begin, with parameter: " + Arrays.asList(args));
	}
	
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		System.out.println("The method end.");
	}
	
	@AfterReturning(value="declareJoinPointExpression()", returning="result")
	public void afterRunning(JoinPoint joinPoint, Object result){
		System.out.println("The method return. result: " + result);
	}
	
	@AfterThrowing("declareJoinPointExpression()")
	public void afterThrowing(JoinPoint joinPoint){
		System.out.println("The method exception.");
	}
	
	/*
	@Around("execution(public * com.relay2.aop.Circle.*(..))")
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
