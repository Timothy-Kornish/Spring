package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackage()")
	public void beforeAddAccount(JoinPoint theJoinPoint) {
		System.out.println("\n================");
		System.out.println("Executing @Before advice on all methods in dao package using pointcut");
		System.out.println("================\n");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		// display method arguments
		Object[] args = theJoinPoint.getArgs();
		
		for (Object arg: args) {
			System.out.println("Argument: " + arg);
			
			if (arg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) arg;
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
		
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
	
	// display the method signature
	
	// display method arguments
	
	
}
