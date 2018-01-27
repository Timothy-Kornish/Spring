package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackage()")
	public void beforeAddAccount() {
		System.out.println("\n================");
		System.out.println("Executing @Before advice on all methods in dao package using pointcut");
		System.out.println("================\n");
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forGetMethods()")
	public void performingGet() {
		System.out.println("\n================");
		System.out.println("Performing getter method");
		System.out.println("================\n");
	}
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forSetMethods()")
	public void performingSet() {
		System.out.println("\n================");
		System.out.println("Performing setter method");
		System.out.println("================\n");
	}
	
	
}
