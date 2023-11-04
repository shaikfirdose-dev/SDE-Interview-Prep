package com.firdose.recursion;

import java.util.Scanner;

public class SmartPower {
    
	 public static void main(String[] args) {
	        Scanner scn = new Scanner(System.in);
	        int a = scn.nextInt();
	        int n = scn.nextInt();
	        
	        System.out.println(power(a,n));
	    }
	    
	    public static long power (int a, int n){
	     if (n == 1){
	       return a;
	     }
	        
	     long temp = power(a,n/2);
	      if(n%2 == 0){
	        return temp*temp;
	      }else{
	        return temp*temp*a;
	      }
	   }

}
