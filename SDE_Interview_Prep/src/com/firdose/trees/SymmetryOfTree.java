//Leetcode(easy): https://leetcode.com/problems/symmetric-tree/
//	T.C:O(N)
//	S.C:(N)

package com.firdose.trees;

public class SymmetryOfTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		boolean ans = helper(root.left, root.right);
		return ans;
	}

	public boolean helper(TreeNode p, TreeNode q) {
		if (p == null && q != null) {
			return false;
		}
		if (p != null && q == null) {
			return false;
		}
		if (p == null && q == null) {
			return true;
		}

		if (p.val != q.val) {
			return false;
		}

		boolean left = helper(p.left, q.right);
		boolean right = helper(p.right, q.left);

		if (left == false || right == false) {
			return false;
		}
		return true;

	}
}
