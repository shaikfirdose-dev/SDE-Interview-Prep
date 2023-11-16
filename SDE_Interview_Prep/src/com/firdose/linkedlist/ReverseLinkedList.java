
//Leetcode Link: https://leetcode.com/problems/reverse-linked-list/

package com.firdose.linkedlist;

public class ReverseLinkedList {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	public Node reverseList(Node head) {
        if(head==null){
            return head;
        }
        Node prev = null;
        Node curr = head;
        while(curr!=null){
            Node currp1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr=currp1;
        }
        return prev;
    }

}
