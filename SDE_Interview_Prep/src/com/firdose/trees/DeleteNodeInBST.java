
//Leetcode (medium ): https://leetcode.com/problems/delete-node-in-a-bst/
//	T.C: O(H)
//	S.C:O(H)

package com.firdose.trees;

public class DeleteNodeInBST {

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left != null && root.right == null) {
				return root.left;
			} else if (root.left == null && root.right != null) {
				return root.right;
			} else {
				int max = func(root.left);
				root.val = max;
				root.left = deleteNode(root.left, max);
				return root;
			}
		}
		return root;
	}

	public int func(TreeNode root) {
		while (root.right != null) {
			root = root.right;
		}
		return root.val;
	}

}
