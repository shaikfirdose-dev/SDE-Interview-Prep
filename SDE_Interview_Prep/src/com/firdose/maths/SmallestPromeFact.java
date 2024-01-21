
//GFG: https://www.geeksforgeeks.org/problems/least-prime-factor5216/1?utm_source=gfg
//T.C: O(Nlog(logN))
//S.C: O(N)

package com.firdose.maths;

public class SmallestPromeFact {

	public int[] leastPrimeFactor(int n) {
		// code here
		int[] arr = new int[n + 1];
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = i;
		}
		for (int i = 2; i * i <= n; i++) {
			if (arr[i] == i) {
				for (int j = i * i; j <= n; j += i) {
					arr[j] = Math.min(arr[j], arr[i]);
				}
			}
		}
		return arr;
	}

}
