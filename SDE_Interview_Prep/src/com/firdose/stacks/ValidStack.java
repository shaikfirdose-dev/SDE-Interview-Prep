
//Leetcode 946 : https://leetcode.com/problems/validate-stack-sequences/


package com.firdose.stacks;

import java.util.Stack;

public class ValidStack {

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		// Stack<Integer> stack = new Stack<>();
		// int j=0;
		// for(int val : pushed){
		// stack.push(val);
		// while(!stack.isEmpty() && stack.peek()==popped[j]){
		// stack.pop();
		// j++;
		// }
		// }
		// return stack.isEmpty();

		Stack<Integer> stack = new Stack<>();
		int i = 0; // for pushed array pointer
		int j = 0; // for popped array pointer
		while (i < pushed.length && j < popped.length) { // in this while whether all the elements would be added or
															// elements would be poped
			if (stack.size() == 0) { // if given stack is empty then we should add that element
				stack.push(pushed[i]);
				i++; // move the pointer
				continue;
			}
			if (stack.peek() == popped[j]) { // if stack top element is same as pop array of current element then remove
												// from the stack
				stack.pop();
				j++; // move pop array pointer
			} else { // if not equal the add that element into stack
				stack.push(pushed[i]);
				i++;
			}
		}

		while (j < popped.length && popped[j] == stack.peek()) { // this loop is for popped the elements

			stack.pop(); // if top element of stack equal to popped element then remove element
			j++; // and move popped pointer

		}
		if (stack.size() > 0) { // if size of stack is not empty which means some element are missing
			return false;
		}
		return true; // if stack empty means elements would be in correct form

	}

}
