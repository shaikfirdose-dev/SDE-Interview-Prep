
//Leetcode (medium): https://leetcode.com/problems/longest-increasing-subsequence/

package com.firdose.dp;

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		/*
		 * Approach 1->Brute force pro max
		 * 
		 * generate all the subsequence and pick one and find the maximum length of
		 * increasing subsequence
		 * 
		 * T.C: O(2^N * N)
		 */

		/*
		 * Apprach 2 -> Brute force
		 * 
		 * using dp-> make all the values of dp as 1 Iteratenested loop one loop starts
		 * from index 1 to n Another starts from index-1 to zero compare two values if
		 * they are ascending order then increase the value in dp corresponding to the
		 * index of first loop value index
		 * 
		 * T.C :O(N^2) S.C:O(N)
		 */

		// Algorithm for second approach

		// if(nums.length==0 || nums.length==1){
		// return nums.length;
		// }
		// int n = nums.length;
		// int[] dp = new int[n];
		// Arrays.fill(dp, 1);
		// int ans = Integer.MIN_VALUE;
		// for(int i=1;i<n;i++){
		// for(int j=i-1;j>=0;j--){
		// if(nums[i]>nums[j]){
		// dp[i] = Math.max(dp[i], dp[j]+1);
		// }
		// }

		// ans = Math.max(ans, dp[i]);
		// }
		// return ans;
		// }

		/*
		 * Approach 3-> optimal solution
		 * 
		 * apply binary search on dp by searching ceil of a number 
		 * increment the answer when ceil value acquire new place in dp
		 *  Do the same for all elements in the nums
		 * 
		 * T.C:O(NlogN) S.C:O(N)
		 */

		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
		int n = nums.length;
		int[] dp = new int[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int low = 0;
			int high = ans;
			while (low < high) {
				int m = low + (high - low) / 2;
				if (dp[m] < nums[i]) {
					low = m + 1;
				} else { // dp[m]>=nums[i]
					high = m;
				}
			}
			dp[low] = nums[i];
			if (low == ans) {
				ans++;
			}
		}
		return ans;
	}

}
