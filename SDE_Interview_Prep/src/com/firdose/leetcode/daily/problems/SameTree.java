
//Leetcode :https://leetcode.com/problems/same-tree/
//	T.C:O(N)
//	S.C:O(N)

package com.firdose.leetcode.daily.problems;

public class SameTree {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		/*
		 * if both node are null means both nodes are same in the same location
		 */
		if (p == null && q == null) {
			return true;
		}
		if ((p == null && q != null) || (p != null && q == null)) {   // if any one node is not same at the same location which means nodes are not same
			return false;
		}
		if (p.val != q.val) {   // if the values of the both nodes are not same which means they are not identical trees
			return false;
		}

		boolean left = isSameTree(p.left, q.left);
		boolean right = isSameTree(p.right, q.right);

		if (left == false || right == false) {       //if left or right sub trees are not failed above conditions then trees are not identical 
			return false;
		}
		return true;  // if both are same means they are identical
	}

}
