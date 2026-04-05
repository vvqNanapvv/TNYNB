package org.example.linkedlist;

import org.example.Human;

public class Dll {
    private static class Node{
        Human data;
        Node next;
        Node prev;

        Node(Human human){
            this.data = human;
            this.next = null;
            this.prev = null;
        }
        static class dll {
            private Node head;
            // Insert at the end
            public void insertEnd(Human data) {
                Node newNode = new Node(data);
                if (head == null) {
                    head = newNode;
                    return;
                }
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
            }
            // Insert at the front
            public void insertFront(Human data) {
                Node newNode = new Node(data);
                if (head == null) {
                    head = newNode;
                    return;
                }
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }
    }
}
