
//Leetcode(medium): https://leetcode.com/problems/rotate-list/
//	T.C:O(N)
//	S.C:O(1)

package com.firdose.linkedlist;

public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode temp = head;
		int length = 0;
		while (temp != null) {
			length++;
			temp = temp.next;
		}

		k = k % length;
		if (k == 0) {
			return head;
		}
		temp = head;
		int jumps = length - k;
		for (int i = 1; i < jumps; i++) {
			temp = temp.next;
		}
		ListNode newHead = temp.next;
		temp.next = null;
		temp = head;

		ListNode tempp1 = newHead;
		while (tempp1.next != null) {
			tempp1 = tempp1.next;
		}
		tempp1.next = temp;
		return newHead;

	}
}
