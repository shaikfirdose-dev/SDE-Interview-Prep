
//Leetcode : https://leetcode.com/problems/search-in-a-binary-search-tree/

//T.C: O(N)
//S.C :O(1)

package com.firdose.trees;

public class SearchBST {

	public TreeNode searchBST(TreeNode root, int val) {
		// brute force -----> T.C: O(N) S.C: O(N)
		// if(root==null){
		// return null;
		// }

		// if(root.val==val){
		// return root;
		// }
		// searchBST(root.left, val);
		// searchBST(root.right, val);

		// return null;

		// optimal bfs---
		if (root == null) {
			return null;
		}

		while (root != null) {
			if (root.val == val) {
				return root;
			} else if (root.val > val) {
				root = root.left;
			} else {
				root = root.right;
			}
		}

		return null;

		// dfs
//		if (root == null) {
//			return null;
//		}
//		if (root.val == val) {
//			return root;
//		} else if (root.val < val) {
//			return searchBST(root.right, val);
//		} else {
//			return searchBST(root.left, val);
//		}
	}
}
