
//Leetcode (medium): https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=daily-question&envId=2024-03-03
//	T.C:O(N)
//	S.C:O(1)

		/*  edge cases are very important */
		/* 1. edge case was if number of jumps are one then after reversing the list return reverse of list by passing head.next
		/*
		 * 1.Reverse the linkedlist
		 * 2.Jump n steps
		 * 3.connect next node to next.next
		 * 4.reverse again and return head
		 */

package com.firdose.leetcode.daily.problems;

public class DeleteznthNodeFromEnd {
	
	static class ListNode{
		int val;
		ListNode next;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode newHead = reverse(head);
		if (n == 1) {
			return reverse(newHead.next);
		}
		ListNode temp = newHead;
		for (int i = 1; i < n - 1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;

		return reverse(newHead);
	}

	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode currp1 = curr.next;
			curr.next = prev;
			prev = curr;
			curr = currp1;
		}
		return prev;
	}

}
