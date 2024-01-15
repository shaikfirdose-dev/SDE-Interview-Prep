
//GFG : https://www.geeksforgeeks.org/problems/sum-of-xor-of-all-pairs0723/1?utm_source=gfg
//T.C: O(N)
//S.C:O(1)

package com.firdose.bitmanupulation;

public class SumXOR {

	public long sumXOR(int arr[], int n) {
		// Complete the function

		long ans = 0;
		for (int i = 31; i >= 0; i--) {
			long zeroCnt = 0;
			long oneCnt = 0;
			for (long j : arr) {
				if ((j & (1 << i)) != 0) {
					oneCnt++;
				} else {
					zeroCnt++;
				}
			}
			ans = ans + (((long) 1 << i) * (zeroCnt * oneCnt));
		}
		return ans;
	}

}
