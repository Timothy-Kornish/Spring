package com.timothyKornish.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		// use default bean id
		Coach theCoach = context.getBean("soccerCoach", Coach.class); // use bean component id
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		// close the context
		context.close();
	}

}
