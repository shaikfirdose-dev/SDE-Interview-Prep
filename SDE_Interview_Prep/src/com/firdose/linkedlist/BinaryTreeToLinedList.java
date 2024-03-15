


//Leetcode : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//
//T.C:O(N)
//S.c : O(H)

package com.firdose.linkedlist;

import com.firdose.trees.TreeNode;

public class BinaryTreeToLinedList {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}

	public void flatten(TreeNode root) {
		helper(root);
		return;
	}

	public static TreeNode helper(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode leftTail = helper(root.left);
		TreeNode rightTail = helper(root.right);

		if (leftTail == null && rightTail == null) {
			return root;
		} else if (leftTail == null && rightTail != null) {
			return rightTail;
		} else if (leftTail!= null && rightTail == null) {
			TreeNode leftChild = root.left;
			root.left = null;
			root.right = leftChild;
			return leftTail;
		} else { // leftTail!=null && rightTail!=null
			TreeNode leftChild = root.left;
			TreeNode rightChild = root.right;
			root.left = null;
			root.right = leftChild;
			leftTail.right = rightChild;

			return rightTail;
		}

	}

}
