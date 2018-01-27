package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	// add a new advice for @After on findAccounts method
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @Ater (finally) on method: " + method);
				
	}
	
	// add a new advice for @AfterThrowing on findAccounts method
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
				JoinPoint theJoinPoint, Throwable theExc) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @AterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n=======>>> The exception is: " + theExc);

	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
				JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @AterReturning on method: " + method);
		
		// print out the result of the method call
		System.out.println("\n=======>>> result is: " + result);
		
		// lets post-process the data ... let's modify it 
		
		
		// convert the account naes to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n=======>>> result is: " + result);
	}
	
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
		
	}



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
