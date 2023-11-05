//
//1.Take as input String.
//
//a. Write a recursive function which counts, the number of times “aaa”
//appears in the string. Print the value returned.
//
//b. Write a recursive function which counts, the number of times “aaa”
//appears in the string, but only such instances of “aaa” should be
//considered which do not overlap. Print the value returned.
//
//Example(To be used only for expected output):
//
//Input:
//aaaaaa
//
//output
//4
//2

package com.firdose.recursion;

import java.util.Scanner;

public class CountOfaaa {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(count1(str, 0, 0));
		System.out.println(count2(str, 0, 0));
	}
	//This function is for do not overlap character
	private static int count2(String str, int vdx, int count) {
		if(vdx>=str.length()-2) {
			return count;
		}
		
		if(str.charAt(vdx)=='a' && str.charAt(vdx)==str.charAt(vdx+1) && str.charAt(vdx+1)==str.charAt(vdx+2)) {
			int temp = count2(str, vdx+3, count+1);
			return temp;
		}
		else {
			int temp = count2(str, vdx+1, count);
			return temp;
		}
	}
	
	
	//This function is for overlap characters
	private static int count1(String str, int vdx, int count) {
		
		if(vdx==str.length()-2) {
			return count;
		}
		
		if(str.charAt(vdx)=='a' && str.charAt(vdx)==str.charAt(vdx+1) && str.charAt(vdx+1)==str.charAt(vdx+2)) {
			int temp = count1(str, vdx+1, count+1);
			return temp;
		}
		else {
			int temp = count1(str, vdx+1, count);
			return temp;
		}
	}
	
}
