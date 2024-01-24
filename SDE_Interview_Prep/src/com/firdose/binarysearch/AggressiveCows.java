
//GFG (Hard): https://www.geeksforgeeks.org/problems/aggressive-cows/0

//T.C: O(log(high-low)*N)
//S.C: O(1)


package com.firdose.binarysearch;

import java.util.Arrays;

public class AggressiveCows {

	public static int solve(int n, int k, int[] arr) {
		Arrays.sort(arr);
		int low = arr[n - 1];
		for (int i = 1; i < n; i++) {
			low = Math.min(low, arr[i] - arr[i - 1]);
		}
		int high = arr[n - 1] - arr[0];
		int distance = -1;
		while (low <= high) {
			int m = low + (high - low) / 2;
			int cowPlaced = calculate(arr, m);
			if (cowPlaced >= k) {
				distance = m;
				low = m + 1;
			} else {
				high = m - 1;
			}
		}
		return distance;
	}

	public static int calculate(int[] arr, int m) {
		int cows = 1;
		int lastcowPos = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - lastcowPos >= m) {
				cows++;
				lastcowPos = arr[i];
			}
		}
		return cows;
	}

}
