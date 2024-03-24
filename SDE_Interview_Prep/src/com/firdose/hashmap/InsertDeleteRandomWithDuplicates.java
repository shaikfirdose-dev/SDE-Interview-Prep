
//Leetcode (hard): https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
//	T.C:O(1)

package com.firdose.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class InsertDeleteRandomWithDuplicates {

	class RandomizedCollection {
		HashMap<Integer, HashSet<Integer>> hm;
		ArrayList<Integer> list;
		Random r;

		public RandomizedCollection() {
			hm = new HashMap<>();
			list = new ArrayList<>();
			r = new Random();
		}

		public boolean insert(int val) {
			HashSet<Integer> set;
			boolean flag;
			if (hm.containsKey(val) == true) {
				set = hm.get(val);
				flag = false;
			} else {
				set = new HashSet<>();
				flag = true;
			}

			set.add(list.size());
			hm.put(val, set);
			list.add(val);
			return flag;
		}

		public boolean remove(int val) {
			HashSet<Integer> set;
			if (hm.containsKey(val) == true) {
				set = hm.get(val);
			} else {
				return false;
			}
			int remIdx = -1;
			for (int x : set) {
				remIdx = x;
				break;
			}
			set.remove(remIdx);
			hm.put(val, set);

			if (remIdx == list.size() - 1) {
				list.remove(remIdx);
			}

			else {
				int idx2 = list.size() - 1;
				int temp = list.get(idx2);

				list.set(idx2, val);
				list.set(remIdx, temp);

				list.remove(idx2);

				HashSet<Integer> hset = hm.get(temp);
				hset.remove(idx2);
				hset.add(remIdx);
				hm.put(temp, hset);
			}

			if (hm.get(val).size() == 0) {
				hm.remove(val);
			}
			return true;
		}

		public int getRandom() {
			int rval = r.nextInt(list.size());
			return list.get(rval);

		}
	}

}
