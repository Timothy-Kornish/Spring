package com.timothyKornish.springDemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype") // prototype scope doesn't call destroy method
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	// define init method
	@PostConstruct
	public void startUp() {
		System.out.println(">> TennisCoach: inside startUp method");
	}
	
	// define destroy method
	@PreDestroy
	public void cleanUp() {
		System.out.println(">> TennisCoach: inside cleanUp method");
	}
	
	/*
	// setter method autowire injection
	@Autowired // autowiring can work on any method
	public void setFortuneService(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
		System.out.println(">> TennisCoach: inside setFortuneService method");
	}
	*/
	
	
	/*
	@Autowired // constructor autowire injection
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}
