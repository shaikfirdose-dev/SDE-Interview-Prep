
//Delete a Node: https://practice.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1

package com.firdose.linkedlist;


public class DeleteKthNode {
	
	Node deleteKthNode(Node head, int k) {
		if(head==null) {  // edge case --> if no nodes are exists in linkedlist
			return null;
		}
		if(k==1 && head.next==null) { // here if only one node exists
			return null;
		}
		if(k==1 && head.next!=null) { // here more than one node exists so change head to next node
			head = head.next;
			return head;
		}
		Node temp = head;   // here taking head referece in temp, this should take while iterating the linkked list
		for(int i=1;i<k-1;i++) {
			temp=temp.next;
		}
		Node tempp1 = temp.next.next;   // here storing next next node because of connection need to maintain
		Node del = temp.next;          // storing the node for deletion
		del.next = null;				// here assign del node to null 	
		temp.next=tempp1;				// making connection to next next node
		return head;					// here returing head
	}
}
