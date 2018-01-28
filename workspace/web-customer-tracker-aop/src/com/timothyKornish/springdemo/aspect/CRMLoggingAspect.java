package com.timothyKornish.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.timothyKornish.springdemo.controller.*.*(..))")
	public void forControllerPackage() {} 
	
	@Pointcut("execution(* com.timothyKornish.springdemo.service.*.*(..))")
	public void forServicePackage() {} 
	
	@Pointcut("execution(* com.timothyKornish.springdemo.dao.*.*(..))")
	public void forDAOPackage() {} 
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @Before calling method: " + method);
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		for (Object arg : args) {
			myLogger.info("=====>>> argument: " + arg);
		}
		
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "result")
	public void afterReturning(JoinPoint theJoinPoint, Object result) {
		
		// display method we are in
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @AfterReturning from method: " + method);
		
		// display data returned
		myLogger.info("=====>>> result: " + result);
	}
	
}
