package com.firdose.trees;

public class CeilOfBST {

	class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

	public static int findCeil(TreeNode<Integer> root, int x) {

		// Write your code here
		TreeNode<Integer> ans = new TreeNode<Integer>(-1);
		while (root != null) {
			if (root.data > x) {
				ans = root;
				root = root.left;
			} else if (root.data < x) {
				root = root.right;
			} else {
				return root.data;
			}
		}
		return ans.data;

	}

}
