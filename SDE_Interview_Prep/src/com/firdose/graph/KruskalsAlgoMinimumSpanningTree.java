
//GFG(medium): https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=geeksforgeeks
//	T.C:O(ElogV)
//	S.C:O(V)

package com.firdose.graph;

import java.util.Arrays;

public class KruskalsAlgoMinimumSpanningTree {

	static int spanningTree(int V, int E, int[][] edges) {
		
		Arrays.sort(edges, (a,b)->Integer.compare(a[2], b[2]));
		int[] parent = new int[V + 1];
		int[] rank = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		int ans = 0;
		for (int i = 0; i < E; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int wt = edges[i][2];
			boolean merge = union(u, v, parent, rank);
			if (merge == true) {
				ans = ans + wt;
			}
		}
		return ans;

	}

	static boolean union(int x, int y, int[] parent, int[] rank) {
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

	static int find(int x, int[] parent) {
		if (x == parent[x]) {
			return x;
		}

		int temp = find(parent[x], parent);
		parent[x] = temp;
		return temp;
	}

}
