

//GFG : https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
//	T.C: O(N)
//	S.C: O(N)


package com.firdose.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderTraversal {

	// User function Template for Java
	
	static class Node{
		int data;
		Node left;
		Node right;
	}

	class Solution {
		static class Pair {
			Node n1;
			int vtl;

			Pair(Node n1, int v) {
				this.n1 = n1;
				this.vtl = v;
			}
		}

		static ArrayList<Integer> verticalOrder(Node root) {
			ArrayList<Integer> ans = new ArrayList<>();

			if (root == null) {
				return ans;
			}
			HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
			Queue<Pair> q = new LinkedList<>();
			q.add(new Pair(root, 0));

			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			while (q.size() > 0) {
				int n = q.size();
				for (int i = 1; i <= n; i++) {
					Pair rem = q.remove();
					Node remNode = rem.n1;
					int verticalLevel = rem.vtl;

					min = Math.min(min, verticalLevel);
					max = Math.max(max, verticalLevel);

					if (hm.containsKey(verticalLevel) == false) {
						hm.put(verticalLevel, new ArrayList());
					}

					hm.get(verticalLevel).add(remNode.data);

					if (remNode.left != null) {
						q.add(new Pair(remNode.left, verticalLevel - 1));
					}
					if (remNode.right != null) {
						q.add(new Pair(remNode.right, verticalLevel + 1));
					}
				}

			}
			for (int i = min; i <= max; i++) {
				ArrayList<Integer> al = hm.get(i);
				for (int ele : al) {
					ans.add(ele);
				}
			}
			return ans;
		}
	}

}
