package org.game.list;

class SllNode {
    String data;
    SllNode next;

    public SllNode(String data) {
        this.data = data;
    }
}

public class Sll {
    SllNode head;

    public void add(String data) {
        SllNode newNode = new SllNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        SllNode cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}