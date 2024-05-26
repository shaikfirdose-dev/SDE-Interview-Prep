
//Leetcode(medium): https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1268740613/
//	T.C:O(N)
//	S.C:O(N)

package com.firdose.slidingwindow;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int maxLen = 0;
		HashSet<Character> set = new HashSet<>();
		int start = 0;
		int end = 0;
		while (end < n) {
			if (!set.contains(s.charAt(end))) {  //if character not present then add it and calculate maxlen
				set.add(s.charAt(end));
				maxLen = Math.max(maxLen, end - start + 1);
				end++;
			} else {
				while (s.charAt(start) != s.charAt(end)) {  // if the character repeate then release the character untill the same character index and increase the starting point
					set.remove(s.charAt(start));
					start++;
				}
				set.remove(s.charAt(start));
				start++;
				set.add(s.charAt(end));
				end++;
			}
		}
		return maxLen;
	}

}
