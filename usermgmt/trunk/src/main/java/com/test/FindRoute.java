package com.test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class FindRoute {
	private Map<String, LinkedHashSet<String>> routes = new HashMap<String, LinkedHashSet<String>>();
	
	static FindRoute GRAPH = new FindRoute();
	
	static {
		GRAPH.addEdge("Bangalore", "Mumbai");
		GRAPH.addEdge("Bangalore", "Pune");
		GRAPH.addEdge("Pune", "Mumbai");
		GRAPH.addEdge("Bangalore", "Chennai");
		GRAPH.addEdge("Chennai", "Pune");
		GRAPH.addEdge("Pune", "Bangalore");
	}

	public static void main(String[] args) {
		findRoutes("Bangalore", "Mumbai");
	}

	private static void findRoutes(String source, String destination) {
		LinkedList<String> visited = new LinkedList<String>();
		visited.add(source);
		breadthFirst(source, destination, visited);
	}

	public void addEdge(String node1, String node2) {
		LinkedHashSet<String> adjacent = routes.get(node1);
		if (adjacent == null) {
			adjacent = new LinkedHashSet<String>();
			routes.put(node1, adjacent);
		}
		adjacent.add(node2);
	}

	public void addTwoWayVertex(String node1, String node2) {
		addEdge(node1, node2);
		addEdge(node2, node1);
	}

	public boolean isConnected(String node1, String node2) {
		Set<String> adjacent = routes.get(node1);
		if (adjacent == null) {
			return false;
		}
		return adjacent.contains(node2);
	}

	public LinkedList<String> adjacentNodes(String last) {
		LinkedHashSet<String> adjacent = routes.get(last);
		if (adjacent == null) {
			return new LinkedList<String>();
		}
		return new LinkedList<String>(adjacent);
	}

	private static void breadthFirst(String source, String destination, LinkedList<String> visited) {
		LinkedList<String> nodes = GRAPH.adjacentNodes(visited.getLast());
		// examine adjacent nodes
		for (String node : nodes) {
			if (visited.contains(node)) {
				continue;
			}
			if (node.equals(destination)) {
				visited.add(node);
				printPath(visited);
				visited.removeLast();
				break;
			}
		}
		// in breadth-first, recursion needs to come after visiting adjacent
		// nodes
		for (String node : nodes) {
			if (visited.contains(node) || node.equals(destination)) {
				continue;
			}
			visited.addLast(node);
			breadthFirst(source, destination, visited);
			visited.removeLast();
		}
	}

	private static void printPath(LinkedList<String> visited) {
		for (String node : visited) {
			System.out.print(node);
			System.out.print(" ");
		}
		System.out.println();
	}
}