package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get account bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring contrainer 
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		accountDAO.addAccount(new Account(), true);
		accountDAO.doWork();
		
		// calling getter and setter methods
		accountDAO.getName();
		accountDAO.getServiceCode();
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("Gold");
		
		// call addAccount for membership
		membershipDAO.addMember();
		
		// close the context
		context.close();
	}

}
