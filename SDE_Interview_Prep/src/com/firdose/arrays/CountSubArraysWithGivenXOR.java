
//InterviewBit(medium): https://www.interviewbit.com/problems/subarray-with-given-xor/
//T.C:O(N)
//S.C:O(N)

package com.firdose.arrays;

import java.util.HashMap;

public class CountSubArraysWithGivenXOR {

	public int solve(int[] A, int B) {
		int n = A.length;
		int count = 0;
		int xor = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int i = 0; i < n; i++) {
			xor = xor ^ A[i];
			int req = xor ^ B;

			count = count + map.getOrDefault(req, 0);

			map.put(xor, map.getOrDefault(xor, 0) + 1);
		}
		return count;
	}

}
