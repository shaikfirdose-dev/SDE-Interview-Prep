


package com.firdose.linkedlist;

public class FindMid {
	 public Node middleNode(Node head) {

	        if(head==null){
	            return null;
	        }
	       
	        if(head.next==null){
	            return head;
	        }
	        if(head.next.next==null){
	            return head.next;
	        }
	        Node slow = head.next;
	        Node fast = head.next.next;
	        while(fast.next!=null && fast.next.next!=null){
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        if(fast.next!=null){
	            return slow.next;
	        }
	        return slow;

	    }

}
