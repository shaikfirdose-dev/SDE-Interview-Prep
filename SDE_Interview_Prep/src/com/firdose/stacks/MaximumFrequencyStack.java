

//Leetcode (hard): https://leetcode.com/problems/maximum-frequency-stack/
//	
//	T.C:O(N)
//	S.C:O(N)

package com.firdose.stacks;

import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStack {

	HashMap<Integer, Stack<Integer>> stack;   // this hashmap is used to store frequency corresponding values in a stack
	HashMap<Integer, Integer> hm;			// this hashmap is to maintain frequency of each element
	int maxFreq = 0;

	public MaximumFrequencyStack() {
        stack = new HashMap<>();
        hm = new HashMap<>();
    }

	public void push(int val) {				//push operation
		int f = hm.getOrDefault(val, 0);    // first get the frequency from frequency hashmap
		f++;								// increment the frequency 
		hm.put(val, f);						// update the ffrequency of that element
		if (stack.containsKey(f) == false) {	//check whether the frequency stack present in stack hashmap or not if not then
			stack.put(f, new Stack<>());		// create one stack corresponding to that frequency
			maxFreq = Math.max(maxFreq, f);		//update the max frequency
		}
		stack.get(f).add(val);              // add the value to that corresponding frequency stack

	}

	public int pop() { 							// pop operation
		int ans = stack.get(maxFreq).pop(); 	// first pop the element from the maximum frequency stack element
		int f = hm.get(ans);					// then get the frequency from the hashmap
		f--;									// decrement it because of removing one element occurance
		hm.put(ans, f);							//then update the frequency corresponding to the value
		if (stack.get(maxFreq).size() == 0) {  // then check whether the frequency stack is empty or not if it is empty 
			stack.remove(maxFreq);				// then remove from the stack hashmap
			maxFreq--;							// then decrement the maxfrequency 
		}	
		return ans;

	}

}
