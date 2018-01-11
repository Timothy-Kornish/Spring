package com.timothyKornish.springdemo;

public class SoccerCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "run iron man sprints across the field";
	}
}
