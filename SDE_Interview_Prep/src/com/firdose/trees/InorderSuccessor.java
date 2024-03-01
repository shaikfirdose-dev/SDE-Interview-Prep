

//GFG (easy) : https://www.geeksforgeeks.org/problems/inorder-successor-in-bst/1
//	T.C:O(H)
//	S.C:O(1)

	/*
	 * there are main two observations in this problem
	 * 1.if root node's right subtree exists then leftmost node of right subtree is the successor of the node
	 * 2.if root node's right subtree does not exists(null) then last left node from the top is the successor of the node
	 */
package com.firdose.trees;

public class InorderSuccessor {
	
	static class Node{
		int data;
		Node left;
		Node right;
	}

	public Node inorderSuccessor(Node root, Node x) {
		if (root == null) {
			return null;
		}

		Node successor = helper(root, x.data);

		return successor;
	}

	public static Node helper(Node root, int k) {
		Node temp = null;
		while (true) {
			if (root.data > k) {
				temp = root;
				root = root.left;
			} else if (root.data < k) {
				root = root.right;
			} else {
				break;
			}
		}
		if (root.right == null) {
			return temp;
		}
		Node rootP1 = root.right;
		while (rootP1.left != null) {
			rootP1 = rootP1.left;
		}
		return rootP1;
	}

}
