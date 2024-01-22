
//Leetcode :https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/

//T.C: O(1)
//S.C: O(1)

package com.firdose.strings;

public class MinimumPushes {

	public int minimumPushes(String word) {
		int n = word.length();
		int ans = 0;
		int push = 1;
		while (n > 0) {
			if ((n - 8) >= 0) {
				ans = ans + 8 * push;
				push++;
				n = n - 8;
			} else {
				ans = ans + n * push;
				break;
			}
		}
		return ans;

	}

}
