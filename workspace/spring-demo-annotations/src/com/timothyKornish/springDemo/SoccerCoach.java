package com.timothyKornish.springDemo;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {
	
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Practice corner kicks for 45 minutes";
	}

	@Override
	public String getDailyFortune() {
		return "Keep sprinting! " + fortuneService.getDailyFortune();
	}

}
