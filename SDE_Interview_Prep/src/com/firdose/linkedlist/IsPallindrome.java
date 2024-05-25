
//Leetcode:https://leetcode.com/problems/palindrome-linked-list/
//	T.C:O(N)
//	S.C:O(1)
package com.firdose.linkedlist;

public class IsPallindrome {

	//brute force --->using stack data structure we can solve this proble but space is O(N)
	
	//Optimal solution
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode temp = reverse(slow);
		ListNode temp1 = head;

		while (temp != null) {
			if (temp1.val != temp.val) {
				return false;
			} else {
				temp = temp.next;
				temp1 = temp1.next;
			}
		}
		return true;
	}

	public ListNode reverse(ListNode node) {
		ListNode curr = node;
		ListNode prev = null;
		while (curr != null) {
			ListNode currp1 = curr.next;
			curr.next = prev;
			prev = curr;
			curr = currp1;
		}
		return prev;
	}
}
