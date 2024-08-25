
//Leetcode(easy): https://leetcode.com/problems/roman-to-integer/
//	T.C:O(N)
//	S.C:O(N)

package com.firdose.strings;

import java.util.HashMap;

public class RomanTOInteger {

	public int romanToInt(String s) {
		int n = s.length();
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
				ans -= map.get(s.charAt(i));
			} else {
				ans += map.get(s.charAt(i));
			}
		}

		return ans;

	}

}
