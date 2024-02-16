
//Leetcode : https://leetcode.com/problems/merge-two-sorted-lists/?tab=Description

//Brute force and Optimal Solution


package com.firdose.linkedlist;

public class MergeTwoSortedList {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		/*------>Brute force------*/
		// ------------->T.C : O((N+M)*(N+M)log(N+M))
		// --------------> S.C : O(N+M)

		// ListNode temp1 = list1;
		// ListNode temp2 = list2;
		// List<Integer> mergedList = new ArrayList<>();
		// while(temp1!=null){
		// mergedList.add(temp1.val);
		// temp1 = temp1.next;
		// }
		// while(temp2!=null){
		// mergedList.add(temp2.val);
		// temp2 = temp2.next;
		// }
		// Collections.sort(mergedList);
		// ListNode dummyNode = new ListNode(-1);
		// ListNode temp = dummyNode;
		// for(int i=0;i<mergedList.size();i++){
		// temp.next = new ListNode(mergedList.get(i));
		// temp = temp.next;
		// }
		// return dummyNode.next;
		
		
		
		

//		/*-------Optimal-------*/
//		/*-------T.C : O(n+m)------S.C : O(1)------*/
		ListNode temp1 = list1;
		ListNode temp2 = list2;

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
