package org.example.linkedlist;

// Neighbor's trait
public class Sll {
    private static class Node {
        String trait;
        Node next;

        public Node(String trait) {
            this.trait = trait;
            this.next = null;
        }
    }
    private Node head = null;
    // Add a new trait to the end of the list
    public void addMessage(String trait) {
        if (trait == null || trait.trim().isEmpty()) {
            System.out.println("Empty trait ignored.");
            return;
        }
        Node newNode = new Node(trait.trim());
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    // Display the trait in order
    public void displayTrait() {
        if (head == null) {
            System.out.println("No conversation to display.");
            return;
        }
        Node current = head;
        int lineNumber = 1;
        while (current != null) {
            System.out.println(lineNumber + ". " + current.trait);
            current = current.next;
            lineNumber++;
        }
    }
}
