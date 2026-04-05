package org.example.linkedlist;

import org.example.Human;

// Neighbor line
public class Sll {
    private static class Node {
        String message;
        Node next;

        Node(String message) {
            this.message = message;
            this.next = null;
        }

        class ConversationList {
            private Node head;

            // Add a new message to the end of the list
            public void addMessage(String message) {
                if (message == null || message.trim().isEmpty()) {
                    System.out.println("Empty message ignored.");
                    return;
                }
                Node newNode = new Node(message.trim());
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

            // Display the conversation in order
            public void displayConversation() {
                if (head == null) {
                    System.out.println("No conversation to display.");
                    return;
                }
                Node current = head;
                int lineNumber = 1;
                while (current != null) {
                    System.out.println(lineNumber + ". " + current.message);
                    current = current.next;
                    lineNumber++;
                }
            }
        }
    }
}
