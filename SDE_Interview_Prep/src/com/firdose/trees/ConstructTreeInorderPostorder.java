package com.firdose.trees;



//Leetcode (medium): https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
//	T.C : O(N)
//	S.C : O(N)

import java.util.HashMap;

public class ConstructTreeInorderPostorder {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
	}

	static HashMap<Integer,Integer>map;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int n = inorder.length;
		map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(inorder[i], i);
		}
		return constructTree(inorder, 0, n - 1, postorder, 0, n - 1);
	}

	public static TreeNode constructTree(int[] inorder, int inS, int inE, int[] postorder, int poS, int poE) {

		if (poS > poE || inS > inE) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[poE]);
		int idx = map.get(postorder[poE]);
		int count = idx - inS;

		root.left = constructTree(inorder, inS, idx - 1, postorder, poS, poS + count - 1);
		root.right = constructTree(inorder, idx + 1, inE, postorder, poS + count, poE - 1);

		return root;
	}

}
