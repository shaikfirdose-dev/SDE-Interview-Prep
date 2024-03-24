package com.firdose.hashmap;

import java.util.HashMap;

public class ZeroSumSubarrays {

	public static long findSubarray(long[] arr, int n) {
		// Your code here
		HashMap<Long, Long> hm = new HashMap<>();
		hm.put((long) 0, 1L);
		long[] psum = func(arr);
		long ans = 0;
		for (int lep = 0; ep < arr.length; ep++) {
			ans = ans + hm.getOrDefault(psum[(int) ep], 0L);
			hm.put(psum[ep], hm.getOrDefault(psum[ep], (long) 0) + 1L);
		}
		return ans;
	}

	public static long[] func(long[] arr) {
		long[] psum = new long[arr.length];
		psum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			psum[i] = psum[i - 1] + 1L;
		}
		return psum;
	}

}
