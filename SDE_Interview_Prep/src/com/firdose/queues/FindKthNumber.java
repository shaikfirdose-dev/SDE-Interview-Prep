//Given K, Print the Kth Number in the increasing series of number using digits 1 and 2 only.


package com.firdose.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindKthNumber {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(KthNumber(k));
    }
    public static String KthNumber(int k){
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");
        
        String ans = "";
        for(int i=1;i<=k;i++){
            String temp = q.remove();
            ans = temp;
            q.add(temp+"1");
            q.add(temp+"2");
        }
        return ans;
    }

}
