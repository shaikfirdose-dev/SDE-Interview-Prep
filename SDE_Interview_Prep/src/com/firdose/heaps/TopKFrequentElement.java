
//Leetcode(medium):https://leetcode.com/problems/top-k-frequent-elements/
//	T.C:O(NlogN)
//	S.C:O(N)

package com.firdose.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElement {

	public int[] topKFrequent(int[] nums, int k) {
		int n = nums.length;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
		}

		ArrayList<Integer> fre = new ArrayList<>();

		for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
			fre.add(e.getValue());
		}

		Collections.sort(fre);

		int j = fre.size() - 1;
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
				if (fre.get(j) == e.getValue()) {
					ans[i] = e.getKey();
					hm.remove(e.getKey());
					j--;
					break;
				}
			}
		}
		return ans;
	}
}
