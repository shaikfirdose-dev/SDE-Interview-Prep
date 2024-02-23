package com.firdose.trees;

//GFG : https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1?itm_source=geeksforgeeks
//	
//	T.C : O(N)
//	S.c: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {
	
	static class Node{
		int data;
		Node left;
		Node right;
	}

	static class Pair {
		Node node;
		int verticalLevel;

		Pair(Node node, int verticalLevel) {
			this.node = node;
			this.verticalLevel = verticalLevel;
		}
	}

	static ArrayList<Integer> topView(Node root) {
		// add your code

		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		HashMap<Integer, Integer> hm = new HashMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		while (queue.size() > 0) {
			int n = queue.size();
			for (int i = 1; i <= n; i++) {
				Pair rem = queue.remove();
				Node remNode = rem.node;
				int verticalLevel = rem.verticalLevel;

				min = Math.min(min, verticalLevel);
				max = Math.max(max, verticalLevel);

				if (hm.containsKey(verticalLevel) == false) {
					hm.put(verticalLevel, remNode.data);
				}
				if (remNode.left != null) {
					queue.add(new Pair(remNode.left, verticalLevel - 1));
				}
				if (remNode.right != null) {
					queue.add(new Pair(remNode.right, verticalLevel + 1));
				}
			}
		}

		for (int i = min; i <= max; i++) {
			ans.add(hm.get(i));
		}
		return ans;

	}

}
