
//GFG : https://www.geeksforgeeks.org/problems/set-bits0143/1?utm_source=gfg

//		T.C: O(32)=O(lonN)
//		S.C: O(1)

package com.firdose.bitmanupulation;

public class CountSetBit {

	static int setBits(int N) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if (checkBit(N, i) == true) {
				count++;
			}

		}
		return count;
	}

	static boolean checkBit(int n, int k) {
		if ((n & (1 << k)) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
