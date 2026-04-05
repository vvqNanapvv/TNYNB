package org.game.list;

class DllNode {
    int score;
    DllNode prev, next;

    public DllNode(int score) {
        this.score = score;
    }
}

public class Dll {
    DllNode head;

    public void add(int score) {
        DllNode newNode = new DllNode(score);

        if (head == null) {
            head = newNode;
            return;
        }

        DllNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = newNode;
        newNode.prev = cur;
    }

    public void print() {
        DllNode cur = head;
        while (cur != null) {
            System.out.print(cur.score + " <-> ");
            cur = cur.next;
        }
        System.out.println("null");
    }
}