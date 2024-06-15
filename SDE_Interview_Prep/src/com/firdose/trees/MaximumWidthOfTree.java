
//Leetcode(medium): https://leetcode.com/problems/maximum-width-of-binary-tree/
//	T.C:O(N)
//	S.C:O(N)

package com.firdose.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfTree {

	static class Pair {
		int idx;
		TreeNode node;

		Pair(int idx, TreeNode node) {
			this.idx = idx;
			this.node = node;
		}
	}

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return -1;
		}

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, root));

		int width = 0;

		while (q.size() > 0) {
			int n = q.size();
			int firstNodeIdx = 0;
			int lastNodeIdx = 0;

			for (int i = 0; i < n; i++) {
				Pair rem = q.remove();
				int idx = rem.idx;
				TreeNode node = rem.node;

				if (i == 0) {
					firstNodeIdx = idx;
				}
				if (i == n - 1) {
					lastNodeIdx = idx;
				}
				if (node.left != null) {
					q.add(new Pair(2 * idx + 1, node.left));
				}
				if (node.right != null) {
					q.add(new Pair(2 * idx + 2, node.right));
				}
			}
			width = Math.max(width, lastNodeIdx - firstNodeIdx + 1);
		}
		return width;

	}

}
