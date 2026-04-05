package org.game.list;

import org.game.Person;

class CllNode {
    Person data;
    CllNode next;

    public CllNode(Person data) {
        this.data = data;
    }
}

public class Cll {
    CllNode head = null;
    CllNode tail = null;

    public void add(Person p) {
        CllNode newNode = new CllNode(p);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public Person getRandom() {
        if (head == null) return null;

        int steps = (int)(Math.random() * 5);
        CllNode cur = head;

        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }

        return cur.data;
    }
}