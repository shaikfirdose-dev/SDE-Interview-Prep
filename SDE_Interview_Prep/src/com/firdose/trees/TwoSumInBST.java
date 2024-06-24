package com.firdose.trees;


//Leetcode: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
//	T.C:O(n)
//	S.C:O(N)

import java.util.ArrayList;

public class TwoSumInBST {

	public boolean findTarget(TreeNode root, int k) {
		ArrayList<Integer> al = new ArrayList<>();
		helper(root, al);

		int start = 0;
		int end = al.size() - 1;

		while (start < end) {
			int sum = al.get(start) + al.get(end);

			if (sum > k) {
				end--;
			} else if (sum < k) {
				start++;

			} else {
				return true;
			}
		}
		return false;
	}

	public void helper(TreeNode root, ArrayList<Integer> al) {
		if (root == null) {
			return;
		}
		helper(root.left, al);
		al.add(root.val);
		helper(root.right, al);
		return;
	}

}
