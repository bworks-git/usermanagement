package com.test;
import java.io.FileNotFoundException;


public class Dog2 implements AnimalI {

	public Dog2() {
		super();
		System.out.println("A new dog has been created!");
	}

	@Override
	public String sleep(String obj) {
		System.out.println("A dog sleeps...");
		return null;
	}
	
	@Override
	public void walk() throws FileNotFoundException {
		System.out.println("A dog sleeps...");
	}
	
	public static void main(String a[]) {
		String s1 = "anil";
		String s2 = s1.replace('n', 'i');
		s1.concat("kapoor");
		System.out.println(s1);
		System.out.println((s1 + s2).charAt(5));
	}
	
}
