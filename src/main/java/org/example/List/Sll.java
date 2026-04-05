package org.example.List;

public class Sll {
    class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    Node head;

    public void add(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}

