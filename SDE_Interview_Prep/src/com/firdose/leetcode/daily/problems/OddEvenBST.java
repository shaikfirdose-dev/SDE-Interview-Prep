
//Leetcode (meium): https://leetcode.com/problems/even-odd-tree/?envType=daily-question&envId=2024-02-29

//T.C : O(N)
//S.C:O(N)


package com.firdose.leetcode.daily.problems;

import java.util.LinkedList;
import java.util.Queue;

public class OddEvenBST {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}

	public boolean isEvenOddTree(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean flag = true;  //level odd or even
		while (q.size() > 0) {
			int n = q.size();
			int prev = flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			for (int i = 1; i <= n; i++) {
				TreeNode rem = q.remove();
				if (flag) {
					if (rem.val % 2 == 0 || prev >= rem.val) {
						return false;
					}
				} else {
					if (rem.val % 2 != 0 || prev <= rem.val) {
						return false;
					}
				}
				prev = rem.val;

				if (rem.left != null) {
					q.add(rem.left);
				}
				if (rem.right != null) {
					q.add(rem.right);
				}
			}
			flag = flag ? false : true;
		}
		return true;

	}

}
