package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// add a new advice for @Around for getFortune method
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out which method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=======>>> Executing @Around on method: " + method);
		
		// begin a timestamp
		long begin = System.currentTimeMillis();
		
		// execute method
		Object result =null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			// rethrowing exception
			throw e;
		}
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n=======>>> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
	
	
	// add a new advice for @After on findAccounts method
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=======>>> Executing @After (finally) on method: " + method);
				
	}
	
	// add a new advice for @AfterThrowing on findAccounts method
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
				JoinPoint theJoinPoint, Throwable theExc) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=======>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		myLogger.info("\n=======>>> The exception is: " + theExc);

	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
				JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=======>>> Executing @AfterReturning on method: " + method);
		
		// print out the result of the method call
		myLogger.info("\n=======>>> result is: " + result);
		
		// lets post-process the data ... let's modify it 
		
		
		// convert the account naes to uppercase
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n=======>>> result is: " + result);
	}
	
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
		
	}



	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackage()")
	public void beforeAddAccount(JoinPoint theJoinPoint) {
		myLogger.info("\n================");
		myLogger.info("Executing @Before advice on all methods in dao package using pointcut");
		myLogger.info("================\n");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methodSig);
		
		// display method arguments
		Object[] args = theJoinPoint.getArgs();
		
		for (Object arg: args) {
			myLogger.info("Argument: " + arg);
			
			if (arg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) arg;
				myLogger.info("Account name: " + theAccount.getName());
				myLogger.info("Account level: " + theAccount.getLevel());
			}
		}
		
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forGetMethods()")
	public void performingGet() {
		myLogger.info("\n================");
		myLogger.info("Performing getter method");
		myLogger.info("================\n");
	}
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forSetMethods()")
	public void performingSet() {
		myLogger.info("\n================");
		myLogger.info("Performing setter method");
		myLogger.info("================\n");
	}
	
	// display the method signature
	
	// display method arguments
	
	
}
