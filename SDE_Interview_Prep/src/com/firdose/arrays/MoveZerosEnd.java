
//Leetcode(easy): https://leetcode.com/problems/move-zeroes/
//	T.C:O(N)
//	S.C:O(1)

package com.firdose.arrays;

public class MoveZerosEnd {

	public void moveZeroes(int[] nums) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
		}
		return;
	}

}
