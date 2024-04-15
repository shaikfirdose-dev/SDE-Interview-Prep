

//GFG(medium): https://www.geeksforgeeks.org/problems/lcs-of-three-strings0028/1?itm_source=geeksforgeeks
//	T.C:O(n*m*o)
//	S.C:O(n*m*o)


package com.firdose.dp;

import java.util.Arrays;

public class LCSonThreeStrings {

	int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
		// code here
		int[][][] dp = new int[n1][n2][n3];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		int ans = helper(A, B, C, n1 - 1, n2 - 1, n3 - 1, dp);
		return ans;

	}

	int helper(String A, String B, String C, int i, int j, int k, int[][][] dp) {
		if (i == -1 || j == -1 || k == -1) {
			return 0;
		}

		if (dp[i][j][k] != -1) {
			return dp[i][j][k];
		}

		if (A.charAt(i) == B.charAt(j) && A.charAt(i) == C.charAt(k)) {
			int x = helper(A, B, C, i - 1, j - 1, k - 1, dp);
			dp[i][j][k] = x + 1;
			return x + 1;
		} else {
			int max = -1;
			int x = helper(A, B, C, i - 1, j, k, dp);
			int y = helper(A, B, C, i, j - 1, k, dp);
			max = Math.max(x, y);
			int z = helper(A, B, C, i, j, k - 1, dp);
			max = Math.max(max, z);

			dp[i][j][k] = Math.max(max, z);

			return Math.max(max, z);
		}
	}

}
