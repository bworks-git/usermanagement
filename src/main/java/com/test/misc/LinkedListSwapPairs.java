package com.test.misc;

public class LinkedListSwapPairs {

	/**
	 * Input          : [3] -> [7] -> [4] -> [9] -> [8] -> [12] 
	 * Expected output: [7] -> [3] -> [9] -> [4] -> [12] -> [8]
	 * @param head node
	 */
	public void switchPairs(Node head) {
		if (head == null || head.next == null)
			return;
		// keep a pointer to next element of head
		Node current = head.next;
		// make head point to next element
		head.next = current.next;
		current.next = head;
		head = current;
		// current has moved one step back it points to first.
		// so get it to the finished swap position
		current = current.next;
		while (current.next != null && current.next.next != null) {
			Node temp = current.next.next;
			current.next.next = temp.next;
			temp.next = current.next;
			current.next = temp;
			current = temp.next;
		}
	}

	public class Node {
		Object value;
		Node next;
	}
}
