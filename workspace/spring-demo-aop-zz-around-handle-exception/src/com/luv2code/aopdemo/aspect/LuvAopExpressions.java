package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

	// create pointcut for all methods in all classes of dao package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
		
	// create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void forGetMethods() {}
		
	// create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void forSetMethods() {}
		
	// create poincut: include dao package ... exclude getter/setter methods
	@Pointcut("forDaoPackage() && !(forGetMethods() || forSetMethods())")
	public void forDaoPackageNoGetterSetter() {}
		
}
