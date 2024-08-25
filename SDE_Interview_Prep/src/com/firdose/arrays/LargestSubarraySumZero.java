
//GFG(medium): https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
//	T.C:O(N)
//	S.C:O(N)

package com.firdose.arrays;

import java.util.HashMap;

public class LargestSubarraySumZero {
	int maxLen(int arr[], int n) {
		int maxLen = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0) {
				maxLen = i + 1;
			} else {
				if (map.get(sum) != null) {
					maxLen = Math.max(maxLen, i - map.get(sum));
				} else {
					map.put(sum, i);
				}
			}

		}
		return maxLen;

	}

}
