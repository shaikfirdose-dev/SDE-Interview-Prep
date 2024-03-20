
//gfg(medium): https://www.geeksforgeeks.org/problems/equal-0-1-and-23208/1?utm_source=gfg
//	
//	T.C:O(N)
//	S.C:O(N)

package com.firdose.hashmap;

import java.util.HashMap;

public class CountSubarraysEquals012 {

	long getSubstringWithEqual012(String str) {
		// code here
		char[] arr = str.toCharArray();
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("0@0", 1);
		int[] prefixCountZero = func1(arr);
		int[] prefixCountOne = func2(arr);
		int[] prefixCountTwo = func3(arr);

		int ans = 0;
		for (int ep = 0; ep < arr.length; ep++) {
			int diff1 = prefixCountZero[ep] - prefixCountTwo[ep];
			int diff2 = prefixCountZero[ep] - prefixCountOne[ep];
			String s = diff1 + "@" + diff2;
			ans = ans + hm.getOrDefault(s, 0);
			hm.put(s, hm.getOrDefault(s, 0) + 1);
		}
		return (long) ans;
	}

	public int[] func1(char[] arr) {
		int[] prefixCountZero = new int[arr.length];
		if (arr[0] - '0' == 0) {
			prefixCountZero[0] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - '0' == 0) {
				prefixCountZero[i] = prefixCountZero[i - 1] + 1;
			} else {
				prefixCountZero[i] = prefixCountZero[i - 1];
			}

		}
		return prefixCountZero;
	}

	public int[] func2(char[] arr) {
		int[] prefixCountOne = new int[arr.length];
		if (arr[0] - '0' == 1) {
			prefixCountOne[0] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - '0' == 1) {
				prefixCountOne[i] = prefixCountOne[i - 1] + 1;
			} else {
				prefixCountOne[i] = prefixCountOne[i - 1];
			}
		}
		return prefixCountOne;
	}

	public int[] func3(char[] arr) {
		int[] prefixCountTwo = new int[arr.length];
		if (arr[0] - '0' == 2) {
			prefixCountTwo[0] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - '0' == 2) {
				prefixCountTwo[i] = prefixCountTwo[i - 1] + 1;
			} else {
				prefixCountTwo[i] = prefixCountTwo[i - 1];
			}
		}
		return prefixCountTwo;
	}

}
