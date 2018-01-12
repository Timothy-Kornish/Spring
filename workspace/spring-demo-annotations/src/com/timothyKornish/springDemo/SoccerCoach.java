package com.timothyKornish.springDemo;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice corner kicks for 45 minutes";
	}

}
