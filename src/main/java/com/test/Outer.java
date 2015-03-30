package com.test;
public class Outer {
	private int x = 100;

	public void makeInner() {
		Inner in = new Inner();
		in.seeOuter();
	}

	class Inner {
		public void seeOuter() {
			System.out.println("Outer x is " + x);
			System.out.println("Inner class reference is " + this);
			System.out.println("Outer class reference is " + Outer.this);
		}
	}

	public static void main(String[] args) {
		Outer o = new Outer();
		Inner i = o.new Inner();
		i.seeOuter();
	}
}