
//Leetcode(medium): https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//	T.C:O(N)
//	S.C:O(H)

package com.firdose.trees;

public class KthSmallestInBST {
	// public int kthSmallest(TreeNode root, int k) {
	// ArrayList<Integer> al = new ArrayList<>();
	// helper(root, al);
	// return al.get(k-1);
	// }

	// public void helper(TreeNode root, ArrayList<Integer> al){

	// if(root==null){
	// return;
	// }

	// helper(root.left, al);
	// al.add(root.val);
	// helper(root.right, al);

	// return;
	// }

	public int kthSmallest(TreeNode root, int k) {
		int[] counter = new int[] { 0 };
		int[] kthSmall = new int[] { Integer.MAX_VALUE };

		helper(root, k, counter, kthSmall);

		return kthSmall[0];
	}

	public void helper(TreeNode root, int k, int[] counter, int[] kthSmall) {
		if (root == null || counter[0] >= k) {
			return;
		}
		helper(root.left, k, counter, kthSmall);

		counter[0]++;
		if (counter[0] == k) {
			kthSmall[0] = root.val;
			return;
		}

		helper(root.right, k, counter, kthSmall);

		return;
	}

}
