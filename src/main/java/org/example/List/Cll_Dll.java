package org.example.List;

//Dynamic Circling actions and Execute
public class Cll_Dll {
    private static class Node {
        String methodName;
        Runnable task; // Store a method as Runnable
        Node next;
        Node prev;

        public Node(String methodName, Runnable task) {
            this.methodName = methodName;
            this.task = task;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head = null;

    // Rotate the head to the next or back
    public void next() {
        head = head.next;
        System.out.println();
    }
    public void back() {
        head = head.prev;
        System.out.println();
    }

    // Method to append a Method() also Circular link & Double link
    public void append(String methodName, Runnable task) {
        Node newNode = new Node(methodName, task);
        if (head == null) {
            head = newNode;
            head.next = head.prev = head; // Circular link
        } else {
            Node tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
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

