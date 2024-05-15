//Leetcode: https://leetcode.com/problems/redundant-connection/
//	T.C:O(V+E)
//	S.C:O(V)

package com.firdose.graph;

public class RedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		int[] parent = new int[n + 1];
		int[] rank = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			boolean merge = union(u, v, parent, rank);
			if (merge == false) {
				return edges[i];
			}
		}
		return new int[2];
	}

	public boolean union(int x, int y, int[] parent, int[] rank) {
		int px = find(x, parent);
		int py = find(y, parent);
		if (px == py) {
			return false;
		}
		if (rank[px] > rank[py]) {
			parent[py] = px;
		} else if (rank[px] < rank[py]) {
			parent[px] = py;
		} else {
			parent[px] = py;
			rank[py]++;
		}
		return true;

	}

	public int find(int x, int[] parent) {
		if (x == parent[x]) {
			return x;
		}
		int temp = find(parent[x], parent);
		parent[x] = temp;
		return temp;
	}

}
