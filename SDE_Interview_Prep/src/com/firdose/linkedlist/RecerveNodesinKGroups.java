
//Leetcode(hard):https://leetcode.com/problems/reverse-nodes-in-k-group/
//	T.C:O(N*K)
//	S.C:O(N)

package com.firdose.linkedlist;

import java.util.ArrayList;

public class RecerveNodesinKGroups {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ArrayList<Integer> alist = new ArrayList<>();
		ListNode temp = head;
		while (temp != null) {
			alist.add(temp.val);
			temp = temp.next;
		}
		int groups = alist.size() / k;
		int jump = 0;
		while (groups > 0) {
			int i = jump;
			int j = jump + k - 1;
			while (i < j) {
				int t = alist.get(i);
				alist.set(i, alist.get(j));
				alist.set(j, t);
				i++;
				j--;
			}
			groups--;
			jump = jump + k;
		}
		ListNode dummyNode = new ListNode(-1);
		ListNode res = dummyNode;
		for (int x = 0; x < alist.size(); x++) {
			res.next = new ListNode(alist.get(x));
			res = res.next;
		}
		return dummyNode.next;
	}

}
