package com.firdose.queues;

import java.util.Queue;
import java.util.Stack;

public class ReverseKelements {
	
	public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        int n = q.size();
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=1;i<=k;i++){    		// add k elements to the stack
            stack.push(q.remove());
        }
        for(int i=1;i<=k;i++){          // add k elements from stack to the queue
            q.add(stack.pop());
        }
        for(int i=1;i<=n-k;i++){		// then remove elements from queue and add to the queue
            q.add(q.remove());
        }
        return q;
    }

}
