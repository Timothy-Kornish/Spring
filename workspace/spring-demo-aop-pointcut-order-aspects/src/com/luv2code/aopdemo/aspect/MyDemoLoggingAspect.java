package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// create pointcut for all methods in all classes of dao package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void forGetMethods() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void forSetMethods() {}
	
	// create poincut: include dao package ... exclude getter/setter methods
	@Pointcut("forDaoPackage() && !(forGetMethods() || forSetMethods())")
	private void forDaoPackageNoGetterSetter() {}
	
	
	@Before("forDaoPackage()")
	public void beforeAddAccount() {
		System.out.println("\n================");
		System.out.println("Executing @Before advice on all methods in dao package using pointcut");
		System.out.println("================\n");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performAPIAnalytics() {
		System.out.println("\n================");
		System.out.println("Performing API analytics function");
		System.out.println("================\n");
	}
	
	@Before("forGetMethods()")
	public void performingGet() {
		System.out.println("\n================");
		System.out.println("Performing getter method");
		System.out.println("================\n");
	}
	
	@Before("forSetMethods()")
	public void performingSet() {
		System.out.println("\n================");
		System.out.println("Performing setter method");
		System.out.println("================\n");
	}
	
	
}
