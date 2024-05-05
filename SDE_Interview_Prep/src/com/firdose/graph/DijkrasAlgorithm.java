//
//GFG(medium): https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1?utm_source=geeksforgeeks
//	T.C:O(E*logV)
//	S.C:O(V)

package com.firdose.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkrasAlgorithm {

	public static class Pair implements Comparable<Pair> {
		int vtx;
		int wsf;

		Pair(int vtx, int wsf) {
			this.vtx = vtx;
			this.wsf = wsf;
		}

		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}

	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
		// Write your code here
		int[] ans = new int[V];
		Arrays.fill(ans, Integer.MAX_VALUE);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(S, 0));
		while (pq.size() > 0) {
			Pair rem = pq.remove();
			if (ans[rem.vtx] != Integer.MAX_VALUE)
				continue;
			ans[rem.vtx] = rem.wsf;
			for (ArrayList<Integer> e : adj.get(rem.vtx)) {
				int nbr = e.get(0);
				int wt = e.get(1);
				if (ans[nbr] != Integer.MAX_VALUE)
					continue;
				pq.add(new Pair(nbr, rem.wsf + wt));
			}
		}
		return ans;

	}

}
