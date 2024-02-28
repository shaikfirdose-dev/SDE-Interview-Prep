
//Leetcode (medium): https://leetcode.com/problems/insert-into-a-binary-search-tree/

//T.C : O(N)
//S.C : O(H)

package com.firdose.trees;

public class InsertNodeInTree {
	
	static class TreeNode{      
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {		 // insert main function 
		if (root == null) {								// if root is null then given val is the root of the tree
			return new TreeNode(val);
		}
		helper(root, val);								//helper function can insert the val at the desired position
		return root;									// after adding the node then return the original root of the tree
	}

	public static void helper(TreeNode root, int val) {
		TreeNode node = new TreeNode(val);               	//first we should create the node of the val

		while (true) {										//here infinite loop is running
			if (root.val > val) {						// if root value is greater than the val means we should go left subtree
				if (root.left == null) {			//before going to the left side of tree check wheather left is null or not
					root.left = node;				//if it is null then link the node to the root left side
					return;							// then break the loop
				} else {							// or else jump to the left side of the tree
					root = root.left;
				}
			} else {							// same for right side of the tree
				if (root.right == null) {		//before going to the right side check right is null or not
					root.right = node;			// if it is null then link the node to the right side of tree
					return;						// break the loop
				} else {						// else jump to the right side of the tree
					root = root.right;
				}
			}
		}
	}
}
