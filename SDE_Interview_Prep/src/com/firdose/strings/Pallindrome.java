package com.firdose.strings;

import java.util.Scanner;

public class Pallindrome {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isPallindrome(str));
    }
    private static boolean isPallindrome(String str){
        int start = 0;
        int end =str.length()-1;
        while(start<end){
            char ch1 = Character.toLowerCase(str.charAt(start));
            char ch2 = Character.toLowerCase(str.charAt(end));
            if(ch1!=ch2){
                return false;
            }
            start++;
            end--;
            
        }
        return true;
    }

}
