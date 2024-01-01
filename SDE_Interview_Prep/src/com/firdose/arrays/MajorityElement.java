
//Leetcode : https://leetcode.com/problems/majority-element/

package com.firdose.arrays;

public class MajorityElement {

	public int majorityElement(int[] nums) {               // Boyer-Moore Majority Vote Algorithm 
		int n = nums.length;
		int val = nums[0];
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (val == nums[i]) {
				count++;
			} else {
				if (count == 0) {
					val = nums[i];
					count = 1;
				} else {
					count--;
				}
			}
		}
		return val;
	}

}
