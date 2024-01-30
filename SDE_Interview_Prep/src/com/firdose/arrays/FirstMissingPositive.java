
//GFG: https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1
//T.C: O(N)
//S.C:O(1)

package com.firdose.arrays;

public class FirstMissingPositive {
	
	int missingNumber(int array[], int n) {
		int len = array.length;
		int i = 0;
		while (i < len) {
			if (array[i] > len || array[i] < 0 || array[i] - 1 == i) {
				i++;
			} else {
				int idx = array[i] - 1;
				if (array[i] == array[idx]) {
					i++;
				}
				int temp = array[i];
				array[i] = array[idx];
				array[idx] = temp;
			}
		}
		for (int j = 0; j < len; j++) {
			if (j != array[j] - 1) {
				return j + 1;
			}
		}
		return len + 1;
	}

}
