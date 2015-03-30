package com.test;
import java.io.FileNotFoundException;


public class Dog extends Animal {
	
	public Dog() {
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
