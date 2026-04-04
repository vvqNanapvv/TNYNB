package org.example;
// Neighbor line
public class Sll {
    private static class Node {
        int data;
        Node next;
        Human human;

        Node(int data, Human human) {
            this.data = data;
            this.next = null;
            this.human = human;
        }
    }

    private Node front;
    private Node rear;
    // Constructor
    public Sll() {
        this.front = null;
        this.rear = null;
    }
    // Enqueue: Add element to the rear
    public void enqueue(int value, Human human) {
        Node newNode = new Node(value,human);
        if (rear == null) { // Queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(value + " enqueued.");
    }
    // Dequeue: Remove element from the front
    public Human dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
        Node current = front;
        front = front.next;
        if (front == null) { // Queue became empty
            rear = null;
        }
        return current.human;
    }
    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
    // Display all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Node current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
