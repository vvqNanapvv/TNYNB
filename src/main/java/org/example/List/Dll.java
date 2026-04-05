package org.example.List;

public class  Dll {
    class Node {
        int score;
        Node prev, next;

        public Node(int score) {
            this.score = score;
        }
    }

    Node head;

    public void add(int score) {
        Node newNode = new Node(score);

        if (head == null) {
            head = newNode;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        newNode.prev = cur;
    }

    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.score + " <-> ");
            cur = cur.next;
        }
        System.out.println("null");

    }
}

