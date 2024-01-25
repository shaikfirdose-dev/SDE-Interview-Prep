
//GFG : https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1?itm_source=geeksforgeeks

//T.C:O(log(high-low)*N)
//S.C:O(1)

package com.firdose.binarysearch;

public class BookAllocation {

	public static int findPages(int[] A, int N, int M) {
		int low = maxArr(A);
		int high = sumArr(A);
		int ans = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int requiredSt = calculate(A, mid);
			if (requiredSt <= M) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static int calculate(int[] A, int m) {
		int students = 1;
		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if (sum > m) {
				students++;
				sum = A[i];
			}

		}
		return students;
	}

	private static int maxArr(int[] A) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			max = Math.max(max, A[i]);
		}
		return max;
	}

	private static int sumArr(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		return sum;
	}

}
