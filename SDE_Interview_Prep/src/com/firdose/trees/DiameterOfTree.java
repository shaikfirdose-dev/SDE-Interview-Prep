
//Leetcode : https://leetcode.com/problems/diameter-of-binary-tree/
//	T.C:O(N)
//	S.C:O(Height)

package com.firdose.trees;

public class DiameterOfTree {

	int ans = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		helper(root);
		return ans;
	}

	public int helper(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int left = helper(root.left);
		int right = helper(root.right);

		ans = Math.max(ans, left + right + 2);
		return Math.max(left, right) + 1;
	}

}
