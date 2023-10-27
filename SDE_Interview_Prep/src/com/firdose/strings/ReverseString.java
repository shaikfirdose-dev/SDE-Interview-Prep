package com.firdose.strings;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		System.out.println(reverseString(str));
	}
	
	private static String reverseString(String str) {
		char[] charArr = str.toCharArray();
		int start = 0;
		int end = charArr.length-1;
		while(start < end ) {
			char temp = charArr[start];
			charArr[start] = charArr[end];
			charArr[end] = temp;
			start++;
			end--;
		}
		return "".valueOf(charArr);
	}

}
