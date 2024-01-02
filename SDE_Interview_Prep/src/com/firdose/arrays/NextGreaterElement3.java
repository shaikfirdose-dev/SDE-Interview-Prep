
//Leetcode : https://leetcode.com/problems/next-greater-element-iii/

package com.firdose.arrays;

public class NextGreaterElement3 {
	public int nextGreaterElement(int n) {
		char[] numArr = (n + "").toCharArray();
		int length = numArr.length;
		int idx = -1;
		for (int i = length - 2; i >= 0; i--) {
			if (numArr[i] < numArr[i + 1]) {
				idx = i;

				break;
			}
		}
		if (idx == -1) {
			return -1;
		}

		char val = numArr[idx];
		int smallestIdx = idx + 1;
		for (int i = idx + 1; i < length; i++) {
			if (numArr[i] > val && numArr[i] <= numArr[smallestIdx]) {
				smallestIdx = i;
			}
		}

		char temp = numArr[idx];
		numArr[idx] = numArr[smallestIdx];
		numArr[smallestIdx] = temp;

		int start = idx + 1;
		int end = length - 1;
		while (start <= end) {
			char temp1 = numArr[start];
			numArr[start] = numArr[end];
			numArr[end] = temp1;
			start++;
			end--;
		}
		long ans = Long.parseLong(new String(numArr));
		if (Integer.MAX_VALUE < ans) {
			return -1;
		}
		int result = (int) ans;
		return result;
	}

}
