package org.example.linkedlist;

import org.example.Human;

public class Dll {
    String name;
    int age;

    public Dll(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

    // Node class for DLL
    class Node {
    Human data;
    Node prev;
    Node next;

    public Node(Human data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
    // Doubly Linked List class
    class dll {
        private Node head;
        private Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    // Add node to the end of the list
    public void addHuman(Human human) {
        Node newNode = new Node(human);
        if (isEmpty()) {
            head = tail = newNode; // head is center
        } else {
            tail.next = newNode;
            newNode.prev = tail; // prev as left
            tail = newNode;
        }
    }
}

