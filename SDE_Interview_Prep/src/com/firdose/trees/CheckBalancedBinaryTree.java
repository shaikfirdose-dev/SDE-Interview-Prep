package com.firdose.trees;

public class CheckBalancedBinaryTree {
	// brute-force --->T.C:O(N^2)
//	public boolean isBalanced(TreeNode root) {
//		if (root == null) {
//			return true;
//		}
//
//		int leftHeight = height(root.left);
//		int rightHeight = height(root.right);
//
//		if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
//			return true;
//		}
//		return false;
//
//	}
//
//	public int height(TreeNode root) {
//		if (root == null) {
//			return 0;
//		}
//
//		int left = height(root.left);
//		int right = height(root.right);
//
//		return Math.max(left, right) + 1;
//	}

//	-------------------------------------------------------
	// optimal T.C:O(N)
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		return helper(root) != -1;
	}

	public int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = helper(root.left);
		if (leftHeight == -1) {
			return -1;
		}

		int rightHeight = helper(root.right);
		if (rightHeight == -1) {
			return -1;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}

		return Math.max(leftHeight, rightHeight) + 1;
	}

}
