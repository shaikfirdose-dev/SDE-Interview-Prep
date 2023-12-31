

//Leetcode : https://leetcode.com/problems/majority-element-ii/


//Question : Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

package com.firdose.arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElements2 {

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		int n = nums.length;
		int val1 = nums[0];
		int count1 = 1;
		int val2 = Integer.MIN_VALUE;
		int count2 = 0;
		for (int i = 1; i < n; i++) {
			if (val1 == nums[i]) {
				count1++;
			} else if (val2 == nums[i]) {
				count2++;
			} else {
				if (count1 == 0) {
					val1 = nums[i];
					count1 = 1;
				} else if (count2 == 0) {
					val2 = nums[i];
					count2 = 1;
				} else {
					count1--;
					count2--;
				}
			}
		}

		int c1 = 0;
		for (int i = 0; i < n; i++) {
			if (val1 == nums[i]) {
				c1++;
			}
		}

		if (c1 > n / 3) {
			ans.add(val1);
		}

		int c2 = 0;
		for (int i = 0; i < n; i++) {
			if (val2 == nums[i]) {
				c2++;
			}
		}
		if (c2 > n / 3) {
			ans.add(val2);
		}

		return ans;
	}

}
