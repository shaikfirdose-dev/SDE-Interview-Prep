package com.firdose.linkedlist;

public class TraverseLinkedList {
	public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        linkedList.traverse();
    }

}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void traverse() {
       Node temp = head;
       while(temp.next!=null) {
    	   System.out.print(temp.data+" ");
    	   temp=temp.next;
       }
       System.out.print(temp.data);
    }
}
