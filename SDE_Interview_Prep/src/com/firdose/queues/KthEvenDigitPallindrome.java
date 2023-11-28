//Given K, Print the Kth Palindrome Number in the increasing series of even digit numbers using digits 1 and 2 only.

package com.firdose.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KthEvenDigitPallindrome {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(KthEvenDigitPallindrome(k));
    }
    public static String KthEvenDigitPallindrome(int k){
        Queue<String> q = new LinkedList<>();
        q.add("11");
        q.add("22");
        
        String ans = "";
        for(int i=1;i<=k;i++){
            String temp = q.remove();
            ans = temp;
            q.add(temp.substring(0,(temp.length()/2))+"11"+ temp.substring((temp.length()/2), temp.length()));
            // System.out.println(temp.substring(0,(temp.length()/2))+"11"+ temp.substring((temp.length()/2), temp.length()));
            q.add(temp.substring(0,(temp.length()/2))+"22"+ temp.substring((temp.length()/2), temp.length()));
            // System.out.println(temp.substring(0,(temp.length()/2))+"22"+ temp.substring((temp.length()/2), temp.length()));
            
        }
        return ans;
    }

}
