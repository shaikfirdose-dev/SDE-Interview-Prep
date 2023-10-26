package com.firdose.strings;

import java.util.Scanner;

public class ToggleString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] charArr = str.toCharArray();
		for(int i=0;i<charArr.length;i++) {
			if(charArr[i]>=65 && charArr[i]<=90) {
				charArr[i]=(char)(charArr[i]+32);
			}
			else if(charArr[i]>=97 && charArr[i]<=122) {
				charArr[i]=(char)(charArr[i]-32);
			}
		}
		System.out.println("".valueOf(charArr));

	}

}
