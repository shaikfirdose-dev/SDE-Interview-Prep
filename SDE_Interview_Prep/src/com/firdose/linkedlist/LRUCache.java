
//Leetcode (medium): https://leetcode.com/problems/lru-cache/
//	
//	T.C: O(1)
//	S.C : O(1)


package com.firdose.linkedlist;

import java.util.HashMap;

class LRUCache {
    static class Node{          // this class is for storing data in this format
        int key;
        int val;
        Node next;
        Node prev;
    }

    HashMap<Integer, Node> hm;    // hashmap is used to check given key is present in cache or not
    Node head;                  // head and tail are two dummy nodes
    Node tail;
    int k;

    public LRUCache(int capacity) {
        k = capacity;
        hm = new HashMap<>();
        head = new Node();
        tail = new Node();

        head.next = tail;           // here connecting both the dummy nodes
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)==false){      // checking the key present in cache or not
            return -1;
        }
        else{                                // here removing the node and added at the last
            int ans = hm.get(key).val;
            Node temp = deleteNode(head, hm.get(key));
            addNode(head, tail, temp);
            return ans;                                 // returning its corresponding value
        }
    }
    
    public void put(int key, int value) {    
        Node res = hm.get(key);                     // here checking if the node is present in cache or not
        if(res==null){                              // if it is new node then check cache is full or not
            if(k==hm.size()){                       // if it is full means the remove first node
                hm.remove(head.next.key);           
                deleteNode(head,head.next);
            }
            Node n1 = new Node();                   // add it to the start of the list
            n1.key = key;
            n1.val = value;
            hm.put(key, n1);
            addNode(head, tail, n1);
        }
        else{
            Node temp = deleteNode(head, res);      // if it is already present in cache then remove the node and add at the first
            temp.key = key;
            temp.val = value;
            hm.put(key, temp);
            addNode(head, tail, temp);
        }
    }

    private static Node deleteNode(Node head, Node temp){     // delete node
        Node tm1 = temp.prev;
        Node tp1 = temp.next;

        tm1.next = tp1;
        tp1.prev = tm1;

        return temp;
    }

    private static void addNode(Node head, Node tail, Node temp){   // add note just before tail
        Node tm1 = tail.prev;

        temp.next = tail;
        tm1.next = temp;

        temp.prev = tm1;
        tail.prev = temp;
    }
}

