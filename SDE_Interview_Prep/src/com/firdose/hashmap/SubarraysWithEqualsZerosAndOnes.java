
//GFG (medium): https://www.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1?utm_source=gfg

package com.firdose.hashmap;

import java.util.HashMap;

public class SubarraysWithEqualsZerosAndOnes {

	/*
	 * 
	 * this is one type of approach to solve this problem
	 * 
	 * T.C :O(N)
	 * S.C:O(N)
	 */
//	static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
//		// add your code here
//		for (int i = 0; i < n; i++) {
//			if (arr[i] == 0) {
//				arr[i] = -1;
//			}
//		}
//		HashMap<Integer, Integer> hm = new HashMap<>();
//		hm.put(0, 1);
//		int[] psum = prefxSum(arr);
//		int ans = 0;
//		for (int ep = 0; ep < n; ep++) {
//			//psum[sp-1] = psum[ep]-0 = psum[ep]
//			// int diff = psum[ep]-k ------> int diff = psum[ep]-0=psum[ep] which is equal
//			// to start point
//			ans = ans + hm.getOrDefault(psum[ep], 0);
//			hm.put(psum[ep], hm.getOrDefault(psum[ep], 0) + 1);
//		}
//		return ans;
//	}
//
//	public static int[] prefxSum(int[] arr) {
//		int[] prefixSum = new int[arr.length];
//		prefixSum[0] = arr[0];
//		for (int i = 1; i < arr.length; i++) {
//			prefixSum[i] = prefixSum[i - 1] + arr[i];
//		}
//		return prefixSum;
//	}
	
	/*
	 * this is generic way of solving this kind of problems
	 * 
	 * T.C:O(N)
	 * S.C:O(N)
	 */
	static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
		// add your code here
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(0, 1);
		int[] prefixCountZero = func1(arr);
		int[] prefixCountOne = func2(arr);
		int ans = 0;
		for (int ep = 0; ep < n; ep++) {
			int diff = prefixCountZero[ep] - prefixCountOne[ep];
			ans = ans + hm.getOrDefault(diff, 0);
			hm.put(diff, hm.getOrDefault(diff, 0) + 1);
		}
		return ans;

	}

	public static int[] func1(int[] arr) {
		int[] prefixCountZero = new int[arr.length];
		if (arr[0] == 0) {
			prefixCountZero[0] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 0) {
				prefixCountZero[i] = prefixCountZero[i - 1] + 1;
			} else {
				prefixCountZero[i] = prefixCountZero[i - 1];
			}
		}
		return prefixCountZero;

	}

	public static int[] func2(int[] arr) {
		int[] prefixCountOne = new int[arr.length];
		if (arr[0] == 1) {
			prefixCountOne[0] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 1) {
				prefixCountOne[i] = prefixCountOne[i - 1] + 1;
			} else {
				prefixCountOne[i] = prefixCountOne[i - 1];
			}
		}
		return prefixCountOne;
	}

}
