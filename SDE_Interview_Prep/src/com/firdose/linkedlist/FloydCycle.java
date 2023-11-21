package com.firdose.linkedlist;

public class FloydCycle {
	
	public Node detectCycle(Node head) {
        Node slow = head;  // initially slow at head position
        Node fast = head;	// also fast at head position
        while(fast!=null && fast.next!=null){     // checking whether it is cycle or not
            slow = slow.next;						// if cycle detect then move slow one step and move fast 2 steps
            fast = fast.next.next;
            if(slow==fast){				// checking both slow and fast are equal or not
                slow = head;			// if equal put slow head place
                while(slow!=fast){		// then move slow and fast one step until slow and fast meets
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;			// if both node meets at same point means return any node slow or fast it will be definitly starting point of the cycle
            }
        }
        return null;			// if cycle is not detect then return null
        
    }

}
