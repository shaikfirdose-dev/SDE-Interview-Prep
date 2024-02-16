


//Leetcode(medium): https://leetcode.com/problems/sort-list/?tab=Description

//T.C: O(NlogN)
//S.C:O(logN) (stack space)

package com.firdose.linkedlist;

public class MergeSortLinkedList {

	/*------Brute force-----*/
	// ListNode temp = head;
	// List<Integer> list = new ArrayList<>();
	// while(temp!=null){
	// list.add(temp.val);
	// }
	// Collections.sort(list);
	// int i=0;
	// while(temp!=null){
	// temp.val = list.get(i);
	// i++;
	// temp = temp.next;
	// }
	// return head;

	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode m = mid(head);
		ListNode h2 = m.next;
		m.next = null;

		ListNode temp1 = sortList(head);
		ListNode temp2 = sortList(h2);
		return merge(temp1, temp2);
	}

	private static ListNode mid(ListNode h1) {
		ListNode slow = h1;
		ListNode fast = h1;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static ListNode merge(ListNode h1, ListNode h2) {
		if (h1 == null) {
			return h2;
		}
		if (h2 == null) {
			return h1;
		}
		ListNode temp1 = h1;
		ListNode temp2 = h2;

		ListNode dummyNode = new ListNode(-1);
		ListNode temp3 = dummyNode;

		while (temp1 != null && temp2 != null) {
			if (temp1.val < temp2.val) {
				temp3.next = temp1;
				temp1 = temp1.next;
				temp3 = temp3.next;
			} else {
				temp3.next = temp2;
				temp2 = temp2.next;
				temp3 = temp3.next;
			}

		}
		if (temp1 != null) {
			temp3.next = temp1;
		} else {
			temp3.next = temp2;
		}

		return dummyNode.next;
	}

}
