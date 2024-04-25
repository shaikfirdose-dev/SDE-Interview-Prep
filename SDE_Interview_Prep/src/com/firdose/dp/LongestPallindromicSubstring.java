
//Leetcode(medium): https://leetcode.com/problems/longest-palindromic-substring/

package com.firdose.dp;

public class LongestPallindromicSubstring {

	public String longestPalindrome(String s) {
		
		/*
		 * brute force
		 * T.C:O(N*N*N)
		 * S.C:O(1)
		 */
		// int n = s.length();
		// int start = 0;
		// int maxLen = 1;
		// for(int i=0;i<n;i++){
		// for(int j=i;j<n;j++){
		// if(isPallindrome(s, i, j)==true){
		// if((j-i+1)>maxLen){
		// start = i;
		// maxLen = j-i+1;
		// }
		// }
		// }
		// }

		// return s.substring(start, start+maxLen);
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
		
		
		/*
		 * 
		 * Optimal Solution
		 * T.C:O(N*N)
		 * S.C:O(N*N)
		 */
		int n = s.length();
		int start = 0;
		int maxLen = 1;
		boolean[][] dp = new boolean[n][n];
		for (int gap = 0; gap < n; gap++) {
			int i = 0;
			int j = gap;
			while (j < n) {
				if (gap == 0) {
					dp[i][j] = true;
				} else if (gap == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = true;
						start = i;
						maxLen = 2;
					}
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						if (dp[i + 1][j - 1] == true) {
							dp[i][j] = true;
							if ((j - i + 1) > maxLen) {
								start = i;
								maxLen = j - i + 1;
							}
						}
					}
				}
				i++;
				j++;
			}

		}
		return s.substring(start, maxLen + start);
	}

}
