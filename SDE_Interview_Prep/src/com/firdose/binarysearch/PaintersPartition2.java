
//GFG (Hard): https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
	
//T.C : O(log(sum-max)*N)
//S.C: O(1)

//VVImp [Many companies asked]

package com.firdose.binarysearch;

public class PaintersPartition2 {
	
	public static long minTime(int[] arr, int n, int k) {
		long low = maxOfArray(arr);
		long high = sumOfArray(arr);
		long ans = -1;
		while (low <= high) {
			long mid = low + (high - low) / 2;
			long requiredPainters = calculate(arr, mid);
			if (requiredPainters <= k) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static long calculate(int[] arr, long mid) {
		long painters = 1;
		long sum = 0;
		for (int unit : arr) {
			if (sum + unit > mid) {
				painters++;
				sum = 0;
			}
			sum += unit;
		}
		return painters;
	}

	private static long maxOfArray(int[] arr) {
		long max = Long.MIN_VALUE;
		for (int a : arr) {
			max = (long) Math.max(max, a);
		}
		return max;
	}

	private static long sumOfArray(int[] arr) {
		long sum = 0;
		for (int a : arr) {
			sum += a;
		}
		return sum;
	}

}
