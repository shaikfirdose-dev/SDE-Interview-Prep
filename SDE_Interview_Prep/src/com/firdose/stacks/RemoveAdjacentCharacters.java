//Question: Given a string S, Remove equal pair of adjacent character and return the final String

package com.firdose.stacks;

import java.util.Scanner;
import java.util.Stack;

public class RemoveAdjacentCharacters {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(removeAj(str));
    }
    private static String removeAj(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(stack.size()==0 || stack.peek()!=str.charAt(i)){
                stack.push(str.charAt(i));
            }
            else{
                stack.pop();
            }
        }
        char[] ch = new char[stack.size()];
        for(int i=ch.length-1;i>=0;i--){
            ch[i] = stack.pop();
        }
        
        
        String str1 = String.copyValueOf(ch);
        System.out.println(str1);
        return str1;
    }
}
