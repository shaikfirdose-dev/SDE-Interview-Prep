
//Leetcode(hard):https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
//	T.C:O(ElogV)
//	S.C:O(V)


package com.firdose.graph;

import java.util.Arrays;

public class RemoveMaxEdgesToMakeGraphTraversal {

	public int maxNumEdgesToRemove(int n, int[][] edges) {
		Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
		int[] parentA = new int[n + 1];
		int[] parentB = new int[n + 1];
		int[] rankA = new int[n + 1];
		int[] rankB = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parentA[i] = parentB[i] = i;
			rankA[i] = rankB[i] = 1;
		}

		int removeEdges = 0;
		int countA = 1;
		int countB = 1;

		for (int i = 0; i < edges.length; i++) {
			int cat = edges[i][0];
			int u = edges[i][1];
			int v = edges[i][2];

			if (cat == 3) {
				boolean mergeA = union(u, v, parentA, rankA);
				boolean mergeB = union(u, v, parentB, rankB);
				if (mergeA == false && mergeB == false) {
					removeEdges++;
				}
				if (mergeA == true) {
					countA++;
				}
				if (mergeB == true) {
					countB++;
				}
			} else if (cat == 2) {
				boolean mergeB = union(u, v, parentB, rankB);
				if (mergeB == false) {
					removeEdges++;
				} else {
					countB++;
				}
			} else {
				boolean mergeA = union(u, v, parentA, rankA);
				if (mergeA == false) {
					removeEdges++;
				} else {
					countA++;
				}
			}
		}
		if (countA != n || countB != n) {
			return -1;
		}
		return removeEdges;
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
