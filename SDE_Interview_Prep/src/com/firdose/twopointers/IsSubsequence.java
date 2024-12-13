
//Leetcode: https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150
//	T.C:O(N)
//	S.C:O(1)

package com.firdose.twopointers;

public class IsSubsequence {

	public boolean isSubsequence(String s, String t) {
		int n1 = s.length();
		int n2 = t.length();
		int i = 0;
		int j = 0;
		while (i < n1 && j < n2) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == n1;
	}

}
