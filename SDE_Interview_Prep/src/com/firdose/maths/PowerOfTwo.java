
//Leetcode(easy): https://leetcode.com/problems/power-of-two/description/
//	T.C:O(n)
//	S.C:O(n)
package com.firdose.maths;

public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		if (n == 0) {
			return false;
		}
		while (n % 2 == 0) {
			n /= 2;
		}
		if (n == 1) {
			return true;
		}
		return false;
	}

}
