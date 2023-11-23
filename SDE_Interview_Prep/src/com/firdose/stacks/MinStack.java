//LeetCode 155: https://leetcode.com/problems/min-stack/description/

package com.firdose.stacks;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

   
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek()>=stack.peek()){
            minStack.push(val);
        }
        
    }
    
    public void pop() {
        if(stack.peek()==minStack.peek()){
            minStack.pop();
        }
        stack.pop();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}



