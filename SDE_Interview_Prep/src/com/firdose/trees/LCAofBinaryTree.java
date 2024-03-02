
//Leetcode (medium): https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
//	
//	T.C : O(N)
//	S.C : O(H)

	/*
	 * 
	 * In binary tree we should for left and right side of the tree
	 * then check the condition if child nodes founds then return the root
	 * After searched left and right side of the root
	 * check if both side is not null then root is the LCA
	 * if left side is found and right side is null then left node is LCA
	 * if right side node found and left side is null then right node is LCA
	 * if both are null then there is no LCA for given nodes
	 */
package com.firdose.trees;

public class LCAofBinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val == p.val || root.val == q.val) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		if (left != null && right == null) {
			return left;
		}
		if (left == null && right != null) {
			return right;
		}
		return null;

	}

}
