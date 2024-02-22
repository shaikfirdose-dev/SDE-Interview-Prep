
//GFG (medium):https://www.geeksforgeeks.org/problems/binary-tree-to-cdll/1?itm_source=geeksforgeeks

//T.c: O(N)
//S.C :O(H)


package com.firdose.linkedlist;

public class BinaryTreeToDublyLinkedList {
	
	static class Node{
		int val;
		Node left;
		Node right;
	}

	Node bTreeToClist(Node root) {
		if (root == null) {
			return null;
		}

		Node leftTail = bTreeToClist(root.left);
		Node rightTail = bTreeToClist(root.right);

		if (leftTail == null && rightTail == null) {
			root.left = root;
			root.right = root;

			return root;
		} else if (leftTail == null && rightTail != null) {
			root.left = root.right = root;

			concatenate(root, rightTail);

			return root;
		} else if (leftTail != null && rightTail == null) {
			root.left = root.right = root;

			concatenate(leftTail, root);

			return leftTail;
		} else {
			root.left = root.right = root;

			concatenate(leftTail, root);
			concatenate(leftTail, rightTail);

			return leftTail;
		}

	}

	static Node concatenate(Node head1, Node head2) {    // connecting two circular linked list
		Node tail1 = head1.left;
		Node tail2 = head2.left;

		tail1.right = head2;
		head2.left = tail1;

		tail2.right = head1;
		head1.left = tail2;

		return head1;
	}

}
