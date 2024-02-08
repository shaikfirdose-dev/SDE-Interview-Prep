
//Leetcode (hard): https://leetcode.com/problems/sliding-window-maximum/

//T.C: O(N-k+1)*logK
//S.C:O(N)

package com.firdose.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] arr = new int[nums.length - k + 1];
		int count = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < k; i++) {
			while (dq.size() > 0 && nums[i] > dq.getLast()) {
				dq.removeLast();
			}
			dq.addLast(nums[i]);
		}
		arr[count++] = dq.getFirst();
		for (int i = k; i < nums.length; i++) {
			while (dq.size() > 0 && nums[i] > dq.getLast()) {
				dq.removeLast();
			}
			dq.addLast(nums[i]);
			if (dq.getFirst() == nums[i - k]) {
				dq.removeFirst();
			}
			arr[count++] = dq.getFirst();
		}
		return arr;

	}

}
