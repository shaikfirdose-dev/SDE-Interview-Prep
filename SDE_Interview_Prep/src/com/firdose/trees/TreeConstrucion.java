

//Leetcode (medium) : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//	T.c:O(N)
//	S.C:O(N)

package com.firdose.trees;

import java.util.HashMap;

public class TreeConstrucion {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
	}

	static HashMap<Integer, Integer> map;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = inorder.length;
		map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(inorder[i], i);
		}
		return constructTree(preorder, 0, n - 1, inorder, 0, n - 1);
	}

	public static TreeNode constructTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
		if (ps > pe || is > ie) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[ps]);
		int idx = map.get(preorder[ps]);
		int count = idx - is;

		root.left = constructTree(preorder, ps + 1, ps + count, inorder, is, idx - 1);
		root.right = constructTree(preorder, ps + count + 1, pe, inorder, idx + 1, ie);

		return root;
	}
}
