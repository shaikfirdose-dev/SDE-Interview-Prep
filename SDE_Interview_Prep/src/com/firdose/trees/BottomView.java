
//GFG : https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1?itm_source=geeksforgeeks

//T.C:O(N)
//S.C : O(N)

package com.firdose.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.firdose.trees.TopView.Node;

public class BottomView {
	static class Node{
		int data;
		Node left;
		Node right;
	}

	static class Pair {
		Node n1;
		int vl;

		Pair(Node n1, int vl) {
			this.n1 = n1;
			this.vl = vl;
		}
	}

	public ArrayList<Integer> bottomView(Node root) {
		// Code here
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		HashMap<Integer, Integer> hm = new HashMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while (q.size() > 0) {
			int n = q.size();
			for (int i = 1; i <= n; i++) {
				Pair rem = q.remove();
				Node remNode = rem.n1;
				int verticalLevel = rem.vl;

				min = Math.min(min, verticalLevel);
				max = Math.max(max, verticalLevel);

				hm.put(verticalLevel, remNode.data);

				if (remNode.left != null) {
					q.add(new Pair(remNode.left, verticalLevel - 1));
				}
				if (remNode.right != null) {
					q.add(new Pair(remNode.right, verticalLevel + 1));
				}
			}
		}
		for (int i = min; i <= max; i++) {
			ans.add(hm.get(i));
		}
		return ans;
	}

}
