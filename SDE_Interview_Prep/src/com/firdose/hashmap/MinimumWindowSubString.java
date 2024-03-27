package com.firdose.hashmap;

import java.util.HashMap;

public class MinimumWindowSubString {

	public String minWindow(String s, String t) {
		if (t.length() > s.length()) {
			return "";
		}
		HashMap<Character, Integer> tmap = new HashMap<>();
		HashMap<Character, Integer> smap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
		}

		int sp = 0;
		int ep = 0;
		int ans = Integer.MAX_VALUE;
		int ansStartIdx = -1;
		int ansEndIdx = -1;
		int matchCount = 0;
		while (ep < s.length()) {
			if (matchCount == t.length()) {
				if ((ep - sp) < ans) {
					ans = ep - sp;
					ansStartIdx = sp;
					ansEndIdx = ep - 1;
				}
				
				//release the character
				smap.put(s.charAt(sp), smap.get(s.charAt(sp)) - 1);
				if (smap.get(s.charAt(sp)) < tmap.getOrDefault(s.charAt(sp), 0)) {
					matchCount--;
				}
				sp++;
			} else {
				//acquiring the character
				smap.put(s.charAt(ep), smap.getOrDefault(s.charAt(ep), 0) + 1);
				if (smap.get(s.charAt(ep)) <= tmap.getOrDefault(s.charAt(ep), 0)) {
					matchCount++;
				}
				ep++;
			}
		}
		
		//finding the smallest length of substring by releasing the character
		while (matchCount == t.length()) {
			if ((ep - sp) < ans) {
				ans = ep - sp;
				ansStartIdx = sp;
				ansEndIdx = ep - 1;
			}
			smap.put(s.charAt(sp), smap.get(s.charAt(sp)) - 1);
			if (smap.get(s.charAt(sp)) < tmap.getOrDefault(s.charAt(sp), 0)) {
				matchCount--;
			}
			sp++;
		}
		//if required number of characters not matched means t is not present in s string
		//if present getting the substring of that
		//else empty substring
		return ans == Integer.MAX_VALUE ? new String() : s.substring(ansStartIdx, ansEndIdx + 1);
	}

}
