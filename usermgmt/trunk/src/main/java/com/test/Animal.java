package com.test;
import java.io.IOException;


public class Animal {
	
	protected int legs;
	
	public Animal() {
		System.out.println("A new animal has been created!");
	}
	
	
	public Object sleep(String obj) {
		System.out.println("A dog sleeps...");
		return null;
	}


	protected void walk() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
