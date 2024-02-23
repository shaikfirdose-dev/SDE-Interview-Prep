
//GFG : https://www.geeksforgeeks.org/problems/right-view-of-binary-tree/1
//	T.C: O(N)
//	S.C : O(N)


package com.firdose.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightView {
	
	static class Node{
		int data;
		Node left;
		Node right;
	}

	ArrayList<Integer> rightView(Node node) {
		// add code here.
		ArrayList<Integer> ans = new ArrayList<>();
		if (node == null) {
			return ans;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (queue.size() > 0) {
			int n = queue.size();
			for (int i = 1; i <= n; i++) {
				Node rem = queue.remove();
				if (i == n) {
					ans.add(rem.data);
				}
				if (rem.left != null) {
					queue.add(rem.left);
				}
				if (rem.right != null) {
					queue.add(rem.right);
				}
			}
		}
		return ans;
	}

}
