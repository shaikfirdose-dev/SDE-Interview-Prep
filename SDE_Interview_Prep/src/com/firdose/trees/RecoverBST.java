package com.firdose.trees;



//Leetcode : https://leetcode.com/problems/recover-binary-search-tree/submissions/1188977222/
//	T.C:O(N)
//	S.C:O(H)

import com.firdose.trees.InsertNodeInTree.TreeNode;

public class RecoverBST {
	
	static class TreeNode{      
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
	}

	static TreeNode firstNode;
	static TreeNode secondNode;
	static TreeNode prev;

	public void recoverTree(TreeNode root) {
		firstNode = null;
		secondNode = null;
		prev = null;
		inorder(root);
		int temp = secondNode.val;
		secondNode.val = firstNode.val;
		firstNode.val = temp;
		return;

	}

	public static void inorder(TreeNode curr) {
		if (curr == null) {
			return;
		}
		inorder(curr.left);
		if (prev != null && curr.val < prev.val && firstNode == null) {
			firstNode = prev;
			secondNode = curr;
		} else if (prev != null && curr.val < prev.val && firstNode != null) {
			secondNode = curr;
		}
		prev = curr;

		inorder(curr.right);
	}

}
