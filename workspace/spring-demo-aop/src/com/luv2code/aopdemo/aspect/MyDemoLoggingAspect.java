package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	// @Before("execution(public void addAccount())")
	// @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	
	// @Before("execution(* add*(com.luv2code.aopdemo.Account))")
	// @Before("execution(* add*(com.luv2code.aopdemo.Account, *))") // one extra parameter of any type
	// @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") // any extra parameters of any type allowed
	// @Before("execution(* add*(..))") // any number of parameters of any type
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccount() {
		System.out.println("\n================");
		System.out.println("Executing @Before advice on method starting with 'add'");
		System.out.println("================\n");
	}
}
