package com.firdose.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


Leetcode(medium): https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		
//		T.C:O(N*KlogK)
//		S.C:O(N*K)
		// int n = strs.length;
		// List<List<String>> ans = new ArrayList<>();
		// Map<String, ArrayList<String>> map = new HashMap<>();
		// for(String s : strs){
		// char[] ch = s.toCharArray();
		// Arrays.sort(ch);
		// String str = new String(ch);
		// if(!map.containsKey(str)){
		// map.put(str, new ArrayList<>());
		// }
		// map.get(str).add(s);
		// }

		// ans = new ArrayList(map.values());
		// return ans;

		
//		T.C:O(N*K)
//		S.C:O(N*K)
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			int[] arr = new int[26];
			for (char ch : s.toCharArray()) {
				arr[ch - 'a']++;
			}

			StringBuilder sb = new StringBuilder();
			for (int i : arr) {
				sb.append("#");
				sb.append(i);
			}

			String key = sb.toString();
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(s);
		}
		return new ArrayList<>(map.values());
	}
}
