package com.firdose.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> ans = new ArrayList<>();

		if (root == null) {
			return ans;
		}
		queue.add(root);

		while (queue.size() > 0) {
			int n = queue.size();
			List<Integer> elements = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				TreeNode temp = queue.remove();
				elements.add(temp.val);
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}

			}
			ans.add(elements);
		}
		Collections.reverse(ans);
		return ans;

	}

}
