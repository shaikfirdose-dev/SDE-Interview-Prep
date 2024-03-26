
//GFG : https://www.geeksforgeeks.org/problems/anagram-palindrome4720/1
//	
//	T.C:O(S)---->String length
//	S.C:O(H)--->distinct characters

package com.firdose.hashmap;

import java.util.HashMap;

public class AnagramPallindrome {

	int isPossible(String S) {
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			hm.put(S.charAt(i), hm.getOrDefault(S.charAt(i), 0) + 1);
		}
		int even = 0;
		int odd = 0;
		for (int x : hm.values()) {
			if (x % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		if (even == hm.size() || odd == 1) {
			return 1;
		}
		return 0;
	}

}
