package com.timothyKornish.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		// use default bean id
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class); // use bean component id
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// call our new swim coach methods
		System.out.println("email: " +theCoach.getEmail());
		System.out.println("team: " +theCoach.getTeam());
		
		
		// close the context
		context.close();
	}

}
