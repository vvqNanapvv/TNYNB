package org.game;

import java.util.LinkedList;

public class Queue {
    LinkedList<Person> queue = new LinkedList<>();

    public void enqueue(Person p) {
        queue.addLast(p);
    }

    public Person dequeue() {
        if (queue.isEmpty()) return null;
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}