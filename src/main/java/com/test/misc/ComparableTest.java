package com.test.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ComparableTest {

	public static void main(String args[]) {
		testComparable();
	}


	private static void testComparable() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "arun", 26, 40000.5, "dbosco"));
		employees.add(new Employee(4, "karun", 19, 50000.75, "dbosco"));
		employees.add(new Employee(3, "tharun", 21, 50000.36, "dbosco"));
		employees.add(new Employee(5, "aarun", 31, 60000.99, "dbosco"));
		employees.add(new Employee(2, "varun", 29, 40000.23, "dbosco"));
		
		System.out.println(employees);
		
		Collections.sort(employees);
		
		System.out.println(employees);
		
		ArrayList<Employee> a = new ArrayList<Employee>();
		a.add(0, null);
		LinkedList<Employee> l = new LinkedList<Employee>();
		l.add(0, null);
		CopyOnWriteArrayList<Employee> c = new CopyOnWriteArrayList<Employee>();
		c.add(null);
		HashSet<Employee> h = new HashSet<Employee>();
		h.add(null);
	}
	
}
