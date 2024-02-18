
//GFG : https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1

//T.c : O(N)
//S.c : O(1)

package com.firdose.linkedlist;



public class DeleteNodeDublyLL {

	Node1 deleteNode(Node1 head, int x) {
		Node1 temp = head;
		int length = 0;
		Node1 lastNode = head;
		while (temp != null) {
			lastNode = temp;
			length++;
			temp = temp.next;
		}

		if (x == 1) {
			head = head.next;
			head.prev = null;
			return head;
		} else if (x == length) {
			lastNode.prev.next = null;
			return head;
		} else {
			Node1 temp1 = head;
			int k = 1;
			while (k < x) {
				temp1 = temp1.next;
				k++;
			}

			Node1 tm1 = temp1.prev;
			Node1 tp1 = temp1.next;

			tm1.next = tp1;
			tp1.prev = tm1;

			return head;
		}

	}

}
