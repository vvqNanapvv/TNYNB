package org.example.List;

//For Circling actions and Execute
public class Cll {
    private static class Node {
        String methodName;
        Runnable task; // Store a method as Runnable
        Node next;

        public Node(String methodName, Runnable task) {
            this.methodName = methodName;
            this.task = task;
            this.next = null;
        }
    }
    // Circular linked list class for Methods
    private Node head = null;
    // Rotate the head by 'positions' steps, In this case is always "1"
    public void rotate(int positions) {
        if (head == null || head.next == head || positions <= 0) {
            return; // Nothing to rotate
        }
        Node temp = head;
        for (int i = 0; i < positions; i++) {
            temp = temp.next;
        }
        head = temp; // Move head to the new position
        System.out.println();
    }
    // Method to append a Method()
    public void append(String methodName, Runnable task) {
        Node newNode = new Node(methodName, task);
        if (head == null) {
            head = newNode;
            head.next = head; // Circular link to itself
            return;
        }
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head; // Circular link
    }
    // Get Method's name
    public String methodName() {
        return (head != null) ? head.methodName : null;
    }
    // Execute at Head -> Method()
    public void executeAt() {
        if (head != null && head.task != null) {
            head.task.run();
        } else {
            System.out.println("No method to execute.");
        }
    }
}

