

//leetcode (medium) : https://leetcode.com/problems/copy-list-with-random-pointer/description/


package com.firdose.linkedlist;

public class CloneLinkedList {

	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		
		/* better solution------------------------T.C : O(2N) = O(N)-----S.C : O(N)+O(N)*/ 
		// if(head==null){
		// return null;
		// }
		// HashMap<Node, Node> hm = new HashMap<>();
		// Node temp = head;

		// while(temp!=null){
		// Node copyNode = new Node(temp.val);
		// hm.put(temp, copyNode);
		// temp = temp.next;
		// }

		// temp = head;
		// while(temp!=null){
		// Node copyNode = hm.get(temp);

		// copyNode.next = hm.get(temp.next);
		// if(temp.random==null){
		// copyNode.random = null;
		// }
		// else{
		// copyNode.random = hm.get(temp.random);
		// }
		// temp = temp.next;
		// }

		// return hm.get(head);
		
		

		/* optimal */
		/* optimal-----------------------T.C : O(2N) = O(N)-----S.C : O(N)*/ 
		insertCopyInBetween(head);
		connectPointers(head);
		return getDeepCopy(head);
	}

	private static void insertCopyInBetween(Node head) {
		Node temp = head;
		while (temp != null) {
			Node copyNode = new Node(temp.val);

			copyNode.next = temp.next;
			temp.next = copyNode;

			temp = temp.next.next;
		}
	}

	private static void connectPointers(Node head) {
		Node temp = head;
		while (temp != null) {
			Node copyNode = temp.next;

			if (temp.random != null) {
				copyNode.random = temp.random.next;
			} else {
				copyNode.random = null;
			}

			temp = temp.next.next;
		}
	}

	private static Node getDeepCopy(Node head) {
		Node temp = head;
		Node dummyNode = new Node(-1);
		Node res = dummyNode;

		while (temp != null) {
			//making copy list
			res.next = temp.next;
			res = res.next;
			
			//disconnecting copy node
			temp.next = temp.next.next;
			
			//jumping next node
			temp = temp.next;
		}
		return dummyNode.next;
	}

}
