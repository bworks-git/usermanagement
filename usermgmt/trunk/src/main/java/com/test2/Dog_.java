package com.test2;
import java.io.FileNotFoundException;

import com.test.Animal;


public class Dog_ extends Animal {
	
	public Dog_() {
		super();
		System.out.println("A new dog has been created!");
	}

	@Override
	public String sleep(String obj) {
		System.out.println("A dog sleeps...");
		return null;
	}
	
	@Override
	protected void walk() throws FileNotFoundException {
		System.out.println("A dog sleeps...");
		legs = 0;
	}

}
