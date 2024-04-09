
//GFG (article): https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
//	
//	T.C:O(NlogN)
//	S.C:O(N)

/*
 * step 1: sort by one parameter
 * step2: apply LIS on other parameter
 */

package com.firdose.dp;

import java.util.Arrays;

public class BuildingBridges {

	public int maxBridges(int[][] bridges) {
		int n = bridges.length;
		Pair1[] arr = new Pair1[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Pair1(bridges[i][0], bridges[i][1]);
		}
		Arrays.sort(arr);

		int dp[] = new int[n];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			int low = 0;
			int high = ans;
			while (low < high) {
				int m = low + (high - low) / 2;
				if (dp[m] < arr[i].south) {
					low = m + 1;
				} else {
					high = m;
				}
			}
			dp[low] = arr[i].south;
			if (low == ans) {
				ans++;
			}
		}
		return ans;
	}

}

class Pair1 implements Comparable<Pair1> {
	int north;
	int south;

	Pair1(int north, int south) {
		this.north = north;
		this.south = south;
	}

	public int compareTo(Pair1 o) {
		if (this.north != o.north) {
			return this.north - o.north;
		} else {
			return o.south - this.south;
		}
	}
}
