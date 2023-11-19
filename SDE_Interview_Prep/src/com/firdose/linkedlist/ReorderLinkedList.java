package com.firdose.linkedlist;

public class ReorderLinkedList {

	public void reorder(Node head) {
		if (head == null || head.next == null) { // edge cases
			return;
		}

		// there are three steps to solve this problem
		// 1. Find mid of linkedList
		// 2. Reverse the second half of linkedList
		// 3. Merge the two linkedList
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node curr = slow.next;
		slow.next = null;
		Node prev = null;

		while (curr != null) {
			Node currp1 = curr.next;
			curr.next = prev;
			prev = curr;
			curr = currp1;
		}

		Node left = head;
		Node right = prev;

		while (right != null) {
			Node leftp1 = left.next;
			Node rightp1 = right.next;

			left.next = right;
			right.next = leftp1;

			left = leftp1;
			right = rightp1;
		}
		return;
	}
}
