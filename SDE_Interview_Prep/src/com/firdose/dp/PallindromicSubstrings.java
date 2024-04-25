
//leetcode(medium): https://leetcode.com/problems/palindromic-substrings/

package com.firdose.dp;

public class PallindromicSubstrings {

	public int countSubstrings(String s) {
		// int n = s.length();
		// int count = 0;
		// for(int i=0;i<n;i++){
		// for(int j=i;j<n;j++){
		// if(isPallindrome(s, i, j)==true){
		// count++;
		// }

		// }
		// }
		// return count;
		// }
		// public boolean isPallindrome(String s, int st, int end){
		// while(st<=end){
		// if(s.charAt(st)!=s.charAt(end)){
		// return false;
		// }
		// st++;
		// end--;
		// }
		// return true;
		// }
		
		//optimal approach
//		T.C:O(N*N)
//		S.C:O(N*N)
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int count = 0;
		for (int gap = 0; gap < n; gap++) {   // gap-->diagonal
			int i = 0;
			int j = gap;
			while (j < n) {
				if (gap == 0) {
					dp[i][j] = true;
					count++;
				} else if (gap == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = true;
						count++;
					}
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						if (dp[i + 1][j - 1] == true) {
							dp[i][j] = true;
							count++;
						}
					}
				}
				i++;
				j++;
			}

		}
		return count;
	}

}
