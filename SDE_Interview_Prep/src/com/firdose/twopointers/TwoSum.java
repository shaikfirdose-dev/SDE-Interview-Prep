package com.firdose.twopointers;

import java.util.Arrays;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {

		int n = nums.length;
		Pair[] arr = new Pair[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Pair(nums[i], i);
		}
		Arrays.sort(arr);
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int left = arr[i].num;
			int right = arr[j].num;
			if (left + right == target) {
				return new int[] { arr[i].idx, arr[j].idx };
			} else if (left + right < target) {
				i++;
			} else {
				j--;
			}
		}
		return new int[2];

	}

	static class Pair implements Comparable<Pair> {
		int num;
		int idx;

		Pair(int a, int b) {
			this.num = a;
			this.idx = b;
		}

		public int compareTo(Pair O) {
			if (this.num != O.num) {
				return this.num - O.num;
			} else {
				return this.idx - O.idx;
			}
		}

	}

}
