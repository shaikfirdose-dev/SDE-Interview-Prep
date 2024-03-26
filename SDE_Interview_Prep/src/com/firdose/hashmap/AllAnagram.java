package com.firdose.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllAnagram {
	public List<Integer> findAnagrams(String s, String p) {
		/*
		 * brute force T.C:O(s*p) S.C:O(p)
		 */
		// if(p.length()>s.length()){
		// return new ArrayList<>();
		// }
		// List<Integer> ans = new ArrayList<>();
		// HashMap<Character, Integer> pmap = new HashMap<>();
		// for(int i=0;i<p.length();i++){
		// pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i),0)+1);
		// }

		// for(int i=0;i<s.length()-p.length()+1;i++){
		// int matchCount =0;
		// HashMap<Character, Integer> smap = new HashMap<>();
		// for(int j=i;j<i+p.length();j++){
		// smap.put(s.charAt(j),smap.getOrDefault(s.charAt(j),0)+1);
		// }

		// for(int j=i;j<i+p.length();j++){
		// if(smap.get(s.charAt(j))==pmap.getOrDefault(s.charAt(j),0)){
		// matchCount++;
		// }
		// }

		// if(matchCount==p.length()){
		// ans.add(i);
		// }

		// }

		// return ans;
		
		
		/*
		 * optimal approach
		 * T.C:O(S+P) 
		 * S.C :O(S)
		 */

		if (p.length() > s.length()) {
			return new ArrayList<>();
		}
		List<Integer> ans = new ArrayList<>();
		HashMap<Character, Integer> pmap = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
		}

		int matchCount = 0;
		HashMap<Character, Integer> smap = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
			if (smap.get(s.charAt(i)) <= pmap.getOrDefault(s.charAt(i), 0)) {
				matchCount++;
			}
		}
		if (matchCount == p.length()) {
			ans.add(0);
		}

		int sp = 0;
		int ep = p.length();

		while (ep < s.length()) {
			// acquire the ep

			smap.put(s.charAt(ep), smap.getOrDefault(s.charAt(ep), 0) + 1);
			if (smap.get(s.charAt(ep)) <= pmap.getOrDefault(s.charAt(ep), 0)) {
				matchCount++;
			}

			// release the start point
			smap.put(s.charAt(sp), smap.get(s.charAt(sp)) - 1);
			if (smap.get(s.charAt(sp)) < pmap.getOrDefault(s.charAt(sp), 0)) {
				matchCount--;
			}

			sp++;
			ep++;

			if (matchCount == p.length()) {
				ans.add(sp);
			}
		}
		return ans;
	}

}
