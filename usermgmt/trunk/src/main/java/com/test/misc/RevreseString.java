package com.test.misc;


public class RevreseString {

	public static void main(String args[]) {
		reverseIt("hello");
	}

	public static String reverseIt(String source) {
	    int i, len = source.length();
	    StringBuilder dest = new StringBuilder(len);

	    for (i = (len - 1); i >= 0; i--){
	        dest.append(source.charAt(i));
	    }

	    System.out.println(dest.toString());
	    return dest.toString();
	}
	
}
