
//Leetcode(medium): https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
//	T.C:O(k^n)  --> k is average number of letters per digit  and n is number of digits
//	S.C:O(n)
package com.firdose.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

	public List<String> letterCombinations(String digits) {

		List<String> ans = new ArrayList<>();
		if (digits.length() == 0) {
			return ans;
		}
		StringBuilder sb = new StringBuilder();
		Map<Character, String> map = getMap();
		helper(0, digits, sb, ans, map);
		return ans;
	}

	public void helper(int i, String digits, StringBuilder sb, List<String> ans, Map<Character, String> map) {
		if (i == digits.length()) {
			ans.add(sb.toString());
			return;
		}

		String alphabets = map.get(digits.charAt(i));
		for (char ch : alphabets.toCharArray()) {
			sb.append(ch);
			helper(i + 1, digits, sb, ans, map);
			sb.deleteCharAt(sb.length() - 1);
		}
		return;

	}

	public Map<Character, String> getMap() {
		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

		return map;

	}

}
