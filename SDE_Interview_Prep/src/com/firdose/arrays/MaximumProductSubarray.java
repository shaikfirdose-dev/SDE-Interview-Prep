
//GFG : https://www.geeksforgeeks.org/problems/maximum-product-subarray3604/1
//	T.C:O(N)
//	S.C:O(N)


package com.firdose.arrays;

public class MaximumProductSubarray {
	// Function to find maximum product subarray
	long maxProduct(int[] arr, int n) {
		// code here
		long prefix = 1;
		long suffix = 1;
		long ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			prefix = prefix * arr[i];
			suffix = suffix * arr[n - i - 1];
			ans = Math.max(ans, Math.max(prefix, suffix));
			if (prefix == 0) {
				prefix = 1;
			}
			if (suffix == 0) {
				suffix = 1;
			}
		}
		return ans;
	}

}
