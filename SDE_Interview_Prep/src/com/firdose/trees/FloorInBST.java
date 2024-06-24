
//T.C:O(H)
//S.C:O(H)

package com.firdose.trees;

public class FloorInBST {
	
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

	public static int floorInBST(TreeNode<Integer> root, int X) {
		// Write your code here.
		TreeNode<Integer> ans = null;
		while (root != null) {
			if (root.data > X) {
				root = root.left;
			} else if (root.data < X) {
				ans = root;
				root = root.right;
			} else {
				return root.data;
			}
		}
		return ans.data;
	}

}
