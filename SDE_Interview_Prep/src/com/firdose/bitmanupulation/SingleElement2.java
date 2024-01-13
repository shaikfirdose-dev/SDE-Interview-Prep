
//Leetcode: https://leetcode.com/problems/single-number-ii/

//T.C: O(32*N)=O(N)
//S.C: O(1)

package com.firdose.bitmanupulation;

public class SingleElement2 {
	

	public int singleNumber(int[] nums) {
		int ans = 0;
		int n = nums.length;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (checkBit(nums[j], i) == true) {
					count++;
				}
			}
			if (count % 3 == 1) {
				ans = ans + (1 << i);
			}
		}
		return ans;
	}

	private static boolean checkBit(int n, int k) {   // checking kth bit is set or not
		if ((n & (1 << k)) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
