
//Leetcode (hard): https://leetcode.com/problems/binary-tree-cameras/
//	T.C:O(N)
//	S.C:O(H)

package com.firdose.trees;

public class MinimumCameras {

	int camera;

	public int minCameraCover(TreeNode root) {
		camera = 0;
		int rootReturn = helper(root);

		if (rootReturn == 0) {
			camera++;
		}
		return camera;
	}

	public int helper(TreeNode root) {

		if (root == null) {
			return 2;
		}

		int left = helper(root.left);
		int right = helper(root.right);

		if (left == 0 || right == 0) {
			camera++;
			return 1;
		}
		if (left == 1 || right == 1) {
			return 2;
		}
		return 0;
	}

}
