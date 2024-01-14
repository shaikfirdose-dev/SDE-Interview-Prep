

//Leetcode : https://leetcode.com/problems/single-number-iii/

//T.C:O(N)
//S.C:O(1)

package com.firdose.bitmanupulation;

public class SingleElement3 {

	public int[] singleNumber(int[] nums) {
		int n = nums.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = ans ^ nums[i];
		}
		int idx = -1;
		for (int i = 0; i < 32; i++) {
			if (checkBit(ans, i) == true) {
				idx = i;
				break;
			}
		}
		int setBitSet = 0;
		int unSetBitSet = 0;
		for (int i = 0; i < n; i++) {
			if (checkBit(nums[i], idx) == true) {
				setBitSet = setBitSet ^ nums[i];
			} else {
				unSetBitSet = unSetBitSet ^ nums[i];
			}
		}
		return new int[] { setBitSet, unSetBitSet };

	}

	private static boolean checkBit(int n, int k) {
		if ((n & (1 << k)) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
