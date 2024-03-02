
//Leetcode (medium): https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//
//	T.C : O(H)
//	S.C: O(1)

	/*		Approach
	 * 
	 * Lowest common ancesstor of binary search tree
	 * 1. If two nodes are grater than root node then go to right subtree
	 * 2. If two nodes are smaller than root node then go to left sub tree
	 * 3. If two nodes are in in between the root value then root must be the Lowest common ancesstor
	 */
package com.firdose.trees;

public class LCAofBST {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		while (true) {
			if (root.val > p.val && root.val > q.val) {
				root = root.left;
			} else if (root.val < p.val && root.val < q.val) {
				root = root.right;
			} else {
				return root;
			}
		}
	}

}
