package com.timothyKornish.springDemo;

public class SadFortuneService implements FortuneService{

	@Override
	public String getDailyFortune() {
		return "Today is gloomy day";
	}

}
