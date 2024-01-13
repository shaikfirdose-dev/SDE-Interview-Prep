

//GFG: https://www.geeksforgeeks.org/problems/flip-bits0240/1

package com.firdose.arrays;

public class FlipBits {
	public static int maxOnes(int a[], int n) {
		int count = 0;
		int cSum = 0;
		int oSum = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				a[i] = 1;
			} else {
				a[i] = -1;
				count++;
			}
		}
		for (int i = 0; i < n; i++) {
			if (cSum >= 0) {
				cSum += a[i];
			} else {
				cSum = a[i];
			}
			oSum = Math.max(oSum, cSum);
		}
		if (oSum > 0) {
			return oSum + count;
		} else {
			return count;
		}
	}
}
