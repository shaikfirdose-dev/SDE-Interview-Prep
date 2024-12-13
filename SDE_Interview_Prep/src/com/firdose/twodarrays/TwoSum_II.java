
//Leetcode(medium): https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150
//	T.C:O(N)
//	S.C:O(1)

package com.firdose.twodarrays;

public class TwoSum_II {

	public int[] twoSum(int[] numbers, int target) {
		int i = 0;
		int j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				return new int[] { i + 1, j + 1 };
			} else if (sum > target) {
				j--;
			} else {
				i++;
			}
		}
		return new int[2];
	}

}
