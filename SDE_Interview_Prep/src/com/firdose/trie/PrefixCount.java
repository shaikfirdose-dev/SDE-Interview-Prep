
//GFG (medium): https://www.geeksforgeeks.org/problems/prefix-match-with-other-strings/1?page=1
//	T.C:O(N*L)
//	S.C:O(N*L)

package com.firdose.trie;

import java.util.HashMap;

public class PrefixCount {

	static class TrieNode {
		int prefixCount;
		HashMap<Character, TrieNode> hm;
		boolean endOfWord;

		TrieNode() {
			prefixCount = 0;
			hm = new HashMap<>();
			endOfWord = false;
		}
	}

	TrieNode root = new TrieNode();

	public int klengthpref(String[] arr, int n, int k, String str) {

		for (String word : arr) {
			insert(word);
		}
		if (k > str.length()) {
			return 0;
		}
		String substring = str.substring(0, k);

		return countPrefixString(substring);

	}

	public void insert(String data) {
		TrieNode temp = root;

		for (int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			if (temp.hm.containsKey(ch) == true) {
				temp = temp.hm.get(ch);
				temp.prefixCount++;
			} else {
				TrieNode node = new TrieNode();
				temp.hm.put(ch, node);
				temp = temp.hm.get(ch);
				temp.prefixCount++;
			}
		}
		temp.endOfWord = true;
		return;

	}

	public int countPrefixString(String s) {
		TrieNode temp = root;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (temp.hm.containsKey(ch) == true) {
				temp = temp.hm.get(ch);
			} else {
				return 0;
			}
		}
		return temp.prefixCount;
	}

}
