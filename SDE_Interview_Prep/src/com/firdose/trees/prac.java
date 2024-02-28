package com.firdose.trees;

import java.util.Arrays;
import java.util.Stack;

public class prac {
	public static String sortString(String s) {
        StringBuilder sortedString = new StringBuilder();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        
        int n = s.length();
        Stack<Character> st = new Stack<>();
        String ss="";
        String rem = "";
        int i=0;
        while(i<n) {
        	char ch = s.charAt(i);
        	if(ss.length()==0) {
        		ss = ss+ch+"";
        		st.push(ch);
        		
        	}
        	else if(ch > st.peek()) {
        		ss = ss+ch+"";
        		st.push(ch);
        		
        	}
        	else {
        		rem = rem+ch+"";
        	
        	}
        	i++;
        }
        int j=rem.length()-1;
        while(j>=0) {
        	char c = rem.charAt(j);
        	ss = ss+c+"";
        	j--;
        }
        return ss;
    }
    
    public static void main(String[] args) {
        String s = "babcbb";
        System.out.println("Original string: " + s);
        System.out.println("Sorted string: " + sortString(s));
    }
	

}
