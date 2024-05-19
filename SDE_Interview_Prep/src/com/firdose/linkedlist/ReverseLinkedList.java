
//Leetcode Link: https://leetcode.com/problems/reverse-linked-list/

package com.firdose.linkedlist;

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
        //brute-force -->T.C:O(N) and S.C:O(N)
        // if(head==null){
        //     return null;
        // }
        // ListNode temp = head;
        // Stack<Integer> st = new Stack<>();
        // while(temp!=null){
        //     st.push(temp.val);
        //     temp = temp.next;
        // }
        // temp =head;
        // while(temp!=null){
        //     temp.val = st.pop();
        //     temp = temp.next;
        // }
        // return head;

		/*
		 * Optimal Solution
		 * T.C:O(N)
		 * S.C:O(1)
		 */
        if(head==null){
            return null;
        }

        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode currp1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currp1;
        }

        return prev;
    }

}
