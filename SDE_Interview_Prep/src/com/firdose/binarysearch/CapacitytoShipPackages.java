

//LeetCode : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

//T.C:O(log(Sum-max)*N)
//S.C:O(1)

package com.firdose.binarysearch;

public class CapacitytoShipPackages {

	public int shipWithinDays(int[] weights, int days) {

		int low = maxOfWeights(weights);   // finding 
		int high = sumOfWeights(weights);

		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int requiredDays = helper(weights, mid);
			if (requiredDays <= days) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public int helper(int[] weights, int maxWeight) {
		int noOfDays = 1;
		int sum = 0;
		for (int wt : weights) {
			if (sum + wt > maxWeight) {
				noOfDays++;
				sum = 0;
			}
			sum += wt;
		}
		return noOfDays;
	}

	private static int sumOfWeights(int[] weights) {
		int sum = 0;
		for (int i = 0; i < weights.length; i++) {
			sum += weights[i];
		}
		return sum;
	}

	private static int maxOfWeights(int[] weights) {
		int maxWeight = Integer.MIN_VALUE;
		for (int i = 0; i < weights.length; i++) {
			maxWeight = Math.max(maxWeight, weights[i]);
		}
		return maxWeight;
	}

}
