
//GFG(medium): https://www.geeksforgeeks.org/problems/trie-insert-and-search0651/1?utm_source=geeksforgeeks
//	T.C:O(N*l)---> number of strings and length of each string
//	S.C:O(N)---> sum of length of all the strings

package com.firdose.trie;

import java.util.HashMap;

public class InsertAndSearchWords {
	
	
//	public static final int ALPHABET_SIZE = 26;
//	static class TrieNode{
//		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
//		boolean isEndOfWord = false;
//		
//		TrieNode(TrieNode childern, boolean eow){
//			for(int i=0;i<ALPHABET_SIZE;i++) {
//				children[i]=null;
//			}
//			isEndOfWord = eow;
//		}
//	}
//	
//	static void insert(TrieNode root, String key) 
//	{
//	    // Your code here
//	    TrieNode temp = root;
//	    for(int i=0;i<key.length();i++){
//	        int idx = key.charAt(i)-'a';
//	        if(temp.children[idx]==null){
//	            temp.children[idx] = new TrieNode();
//	        }
//	        temp = temp.children[idx];
//	       
//	    }
//	    temp.isEndOfWord =true;
//	    return;
//	}
//
//	//Function to use TRIE data structure and search the given string.
//	static boolean search(TrieNode root, String key)
//	{
//	    
//	    // Your code here
//	    TrieNode temp = root;
//	    for(int i=0;i<key.length();i++){
//	        int idx = key.charAt(i)-'a';
//	        if(temp.children[idx]==null){
//	            return false;
//	        }
//	        temp = temp.children[idx];
//	       
//	    }
//	    return temp.isEndOfWord;
//	    
//	}
	
	
	
	static class TrieNode{
	    HashMap<Character, TrieNode> hm = new HashMap<>();
	    boolean eow = false;
	}
	static void insert(TrieNode root, String key) 
	{
	    // Your code here
	    TrieNode t = root;
	    for(int i=0;i<key.length();i++){
	        char ch = key.charAt(i);
	        if(t.hm.containsKey(ch)==true){
	            t = t.hm.get(ch);
	        }
	        else{
	            TrieNode n1 = new TrieNode();
	            t.hm.put(ch,n1);
	            t = t.hm.get(ch);
	        }
	    }
	    return;
	}

	//Function to use TRIE data structure and search the given string.
	static boolean search(TrieNode root, String key)
	{
	    
	    // Your code here
	    TrieNode t = root;
	    for(int i=0;i<key.length();i++){
	        char ch = key.charAt(i);
	        if(t.hm.containsKey(ch)==true){
	            t = t.hm.get(ch);
	        }
	        else{
	            return false;
	        }
	    }
	    return t.eow;
	    
	}

}
