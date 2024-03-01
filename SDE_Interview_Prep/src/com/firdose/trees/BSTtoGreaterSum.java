

//Leetcode (medium): https://leetcode.com/problems/convert-bst-to-greater-tree/
//	
//	T.C :O(N)
//	S.C : O(H)

	/*
	 * Approach
	 * 
	 * Create a static variable to store sum of the node values
	 * In this problem reverse inorder traversal used i.e right->Node->left
	 * Here helper function do the inorder traversal
	 * After reaching the rightmost node 
	 * first add the node value to the static variable
	 * update the current node val
	 * then go to left node
	 * This function repeats until leftmost element will be null
	 */

package com.firdose.trees;

public class BSTtoGreaterSum {

	static int greaterSum;

	public TreeNode convertBST(TreeNode root) {
		greaterSum = 0;
		if (root == null) {
			return null;
		}
		helper(root);
		return root;

	}

	public static void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root.right);
		greaterSum += root.val;
		root.val = greaterSum;
		helper(root.left);
		return;
	}

}
