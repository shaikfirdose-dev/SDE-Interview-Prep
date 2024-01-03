
//Leetcode (medium): https://leetcode.com/problems/maximize-distance-to-closest-person/

package com.firdose.arrays;

public class MaximizeDistance {

	public int maxDistToClosest(int[] seats) {
		int n = seats.length;
		int dist = Integer.MIN_VALUE;
		int pointerA = -1;
		for (int pointerB = 0; pointerB < n; pointerB++) {
			if (seats[pointerB] == 1) {
				if (pointerA == -1) {
					dist = Math.max(dist, pointerB);
				} else {
					dist = Math.max(dist, (pointerB - pointerA) / 2);
				}
				pointerA = pointerB;
			}
		}
		dist = Math.max(dist, n - 1 - pointerA);
		return dist;
	}

}
