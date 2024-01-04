
//Leetcode : https://leetcode.com/problems/max-chunks-to-make-sorted/


package com.firdose.arrays;

public class MaxChunks1 {

	public int maxChunksToSorted(int[] arr) {
		int n = arr.length;
		int count = 0;
		int maxTillNow = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			maxTillNow = Math.max(maxTillNow, arr[i]);
			if (maxTillNow == i) {
				count++;
			}
		}
		return count;

	}

}
