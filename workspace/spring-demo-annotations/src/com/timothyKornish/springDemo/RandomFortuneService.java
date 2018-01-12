package com.timothyKornish.springDemo;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {
		"Beware of the wold in sheep's clothing",
		"Diligence is the mother of good luck",
		"The journey is the reward"
	};
	private Random myRandom = new Random();
	
	// create an arrray of Strigs
	@Override
	public String getDailyFortune() {
		// pick random string from the array 
		int index = myRandom.nextInt(data.length);
		return data[index];
	}

}
