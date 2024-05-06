
//GFG(medium):https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?utm_source=geeksforgeeks
//	T.C:O(E*V)
//	S.C:O(V)
package com.firdose.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {
	static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
		// Write your code here
		int[] ans = new int[V];
		Arrays.fill(ans, 100000000);
		ans[S] = 0;
		for (int i = 0; i < V - 1; i++) {
			for (ArrayList<Integer> e : edges) {
				int u = e.get(0);
				int v = e.get(1);
				int wt = e.get(2);
				if (ans[u] != 100000000 && ans[u] + wt < ans[v]) {
					ans[v] = ans[u] + wt;
				}
			}
		}
		for (ArrayList<Integer> e : edges) {
			int u = e.get(0);
			int v = e.get(1);
			int wt = e.get(2);
			if (ans[u] != 100000000 && ans[u] + wt < ans[v]) {
				int[] an = { -1 };
				return an;
			}
		}

		return ans;
	}
}
