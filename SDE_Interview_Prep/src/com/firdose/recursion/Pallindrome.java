package com.firdose.recursion;

import java.util.Scanner;

public class Pallindrome {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(isPal(str, 0, str.length() - 1));

	}

	private static boolean isPal(String str, int sp, int ep) {

		if (sp >= ep) {
			return true;
		}

		if (str.charAt(sp) == str.charAt(ep)) {
			boolean temp = isPal(str, sp + 1, ep - 1);
			return true;
		} else {
			return false;
		}
	}

}
