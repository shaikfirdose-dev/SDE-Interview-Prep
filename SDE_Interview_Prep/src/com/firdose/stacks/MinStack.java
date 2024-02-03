//LeetCode 155: https://leetcode.com/problems/min-stack/description/

//T.C:O(N)
//S.C:O(1)

package com.firdose.stacks;

import java.util.Stack;

public class MinStack {
//	Stack<Integer> stack = new Stack<>();
//    Stack<Integer> minStack = new Stack<>();
//    
//    public void push(int val) {
//        stack.push(val);
//        if(minStack.isEmpty() || minStack.peek()>=stack.peek()){
//            minStack.push(val);
//        }
//        
//    }
//    
//    public void pop() {
//        if(stack.peek()==minStack.peek()){
//            minStack.pop();
//        }
//        stack.pop();
//        
//    }
//    
//    public int top() {
//        return stack.peek();
//    }
//    
//    public int getMin() {
//        return minStack.peek();
//    }

	// without extra space
	Stack<Long> stack;
	long min;

	public MinStack() {
		stack = new Stack<>();
		min = Integer.MAX_VALUE;
	}

	public void push(int val) {
		if (stack.size() == 0) {
			min = val;
			stack.push(0L);
			return;
		}
		long diff = val - min;
		stack.push(diff);
		if (val < min) {
			min = val;
		}
		return;
	}

	public void pop() {
		long gap = stack.pop();
		if (gap < 0) {
			min = min - gap;
			// min = val;
			return;
		} else {
			long val = min + gap;
		}

	}

	public int top() {
		long top = stack.peek();
		if (top < 0) {
			long val = min;
			return (int) val;
		}
		long val = min + top;
		return (int) val;
	}

	public int getMin() {
		if (stack.size() == 0) {
			return -1;
		}
		return (int) min;
	}
}
