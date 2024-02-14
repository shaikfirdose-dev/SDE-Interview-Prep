
//Leetcode (easy) : https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/?envType=daily-question&envId=2024-02-13
//	T.C:O(N^2)
//	S.C:O(1)


package com.firdose.leetcode.daily.problems;

public class FirstPallindromicString {
	
	public String firstPalindrome(String[] words) {
        int n = words.length;
        for(int i=0;i<n;i++){
            if(isPallindrome(words[i])==true){
                return words[i];
            }
        }
        return "";
    }
    private static boolean isPallindrome(String str){
        int i=0;
        int j=str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
