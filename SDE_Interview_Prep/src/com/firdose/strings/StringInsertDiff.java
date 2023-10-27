package com.firdose.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringInsertDiff {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		System.out.println(stringInsertDiff(str));
	}
	
	private static String stringInsertDiff(String str) {
		String ans = "";
		for(int i=0;i<str.length()-1;i++) {
			char ch = str.charAt(i);
			ans = ans+ch;
			int temp = str.charAt(i+1)-str.charAt(i);
			ans = ans+temp;
		}
		ans = ans+str.charAt(str.length()-1);
		return ans;
	}

}
