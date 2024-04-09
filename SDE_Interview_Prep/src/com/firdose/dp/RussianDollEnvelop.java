
//Leetcode(hard):https://leetcode.com/problems/russian-doll-envelopes/
//	T.C:O(NlogN)
//	S.C:O(N)


/*
 * step 1: sort by one parameter
 * step2: apply LIS on other parameter
 */

package com.firdose.dp;

import java.util.Arrays;

public class RussianDollEnvelop {

	public int maxEnvelopes(int[][] envelopes) {

		int n = envelopes.length;
		Pair[] arr = new Pair[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Pair(envelopes[i][0], envelopes[i][1]);
		}
		Arrays.sort(arr);

		int dp[] = new int[n];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			int low = 0;
			int high = ans;
			while (low < high) {
				int m = low + (high - low) / 2;
				if (dp[m] < arr[i].h) {
					low = m + 1;
				} else {
					high = m;
				}
			}
			dp[low] = arr[i].h;
			if (low == ans) {
				ans++;
			}
		}
		return ans;
	}

}
class Pair implements Comparable<Pair>{
    int w;
    int h;
    Pair(int w, int h){
        this.w = w;
        this.h = h;
    }

    public int compareTo(Pair o){
        if(this.w!=o.w){
            return this.w-o.w;
        }
        else{
            return o.h-this.h;
        }
    }
}
