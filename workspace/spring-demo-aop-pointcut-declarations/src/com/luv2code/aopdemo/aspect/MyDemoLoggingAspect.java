package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccount() {
		System.out.println("\n================");
		System.out.println("Executing @Before advice on all methods in dao package using pointcut");
		System.out.println("================\n");
	}
	
	@Before("forDaoPackage()")
	public void performAPIAnalytics() {
		System.out.println("\n================");
		System.out.println("Performing API analytics function");
		System.out.println("================\n");
	}
}
