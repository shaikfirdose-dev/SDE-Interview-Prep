
//Leetcode(easy):https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//	T.C:O(N)
//	S.C:O(N)

package com.firdose.trees;

public class ConstructArrayToBST {
	static class TreeNode{
		int val;
		TreeNode left; 
		TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		int n = nums.length;
		return helper(0, n - 1, nums);
	}

	public TreeNode helper(int start, int end, int[] nums) {
		if (end < start) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(start, mid - 1, nums);
		root.right = helper(mid + 1, end, nums);

		return root;
	}

}
