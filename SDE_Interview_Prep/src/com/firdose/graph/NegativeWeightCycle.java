
//GFG(MEdium): https://www.geeksforgeeks.org/problems/negative-weight-cycle3504/1?utm_source=geeksforgeeks
//	T.C:O(N*M)
//	S.C:O(N)

package com.firdose.graph;

import java.util.Arrays;

public class NegativeWeightCycle {

	public int isNegativeWeightCycle(int n, int[][] edges) {
		// code here
		int[] arr = new int[n];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		int itr = 1;
		while (itr <= n - 1) {

			for (int i = 0; i < edges.length; i++) {
				int src = edges[i][0];
				int des = edges[i][1];
				int wt = edges[i][2];
				if (arr[src] != Integer.MAX_VALUE && arr[src] + wt < arr[des]) {
					arr[des] = arr[src] + wt;
				}
			}
			itr++;
		}

		for (int i = 0; i < edges.length; i++) {
			int src = edges[i][0];
			int des = edges[i][1];
			int wt = edges[i][2];
			if (arr[src] != Integer.MAX_VALUE && arr[src] + wt < arr[des]) {
				// -ve cycle
				return 1;
			}
		}
		return 0;

	}

}
