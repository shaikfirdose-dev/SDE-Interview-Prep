
//Leetcode(medium): https://leetcode.com/problems/is-graph-bipartite/
//	T.C:O(V+E)
//	S.C:O(V)

package com.firdose.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

	public boolean isBipartite(int[][] graph) {
		int v = graph.length;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				adj.get(i).add(graph[i][j]);
			}
		}

		int[] color = new int[v];
		Arrays.fill(color, -1);
		for (int i = 0; i < v; i++) {
			if (color[i] == -1) {
				if (check(i, adj, color) == false) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean check(int start, ArrayList<ArrayList<Integer>> adj, int[] color) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		color[start] = 0;
		while (!q.isEmpty()) {
			int rem = q.remove();
			for (int it : adj.get(rem)) {
				if (color[it] == -1) {
					color[it] = 1 - color[rem];
					q.add(it);
				} else if (color[it] == color[rem]) {
					return false;
				}
			}
		}
		return true;
	}
}
