
//Question : LeetCode 20: https://leetcode.com/problems/valid-parentheses/

package com.firdose.stacks;

import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isValid(str));

	}
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.size()==0 || s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                if(stack.peek()=='('){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
             else if(s.charAt(i)==']'){
                if(stack.peek()=='['){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
             else{
                if(stack.peek()=='{'){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
        
    }

}
