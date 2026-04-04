package org.example;

public class Dll {
    private static class Node{
        Human data;
        Node next;
        Node prev;

        Node(Human human){
            this.data = human;
            this.next = null;
            this.prev = null;
        }
        class dll {
            private Node head;
            // Insert at the end
            public void insertEnd(Human data) {
                Node newNode = new Node(data);
                if (head == null) {
                    head = newNode;
                    return;
                }
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
            }
            // Insert at the beginning
            public void insertFront(Human data) {
                Node newNode = new Node(data);
                if (head == null) {
                    head = newNode;
                    return;
                }
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            // Delete a node by value
            public boolean delete(Human key) {
                if (head == null) {
                    return false; // Empty list
                }
                Node temp = head;
                // If head node is to be deleted
                if (temp.data == key) {
                    head = temp.next;
                    if (head != null) {
                        head.prev = null;
                    }
                    return true;
                }
                // Search for the node to delete
                while (temp != null && temp.data != key) {
                    temp = temp.next;
                }

                if (temp == null) {
                    return false; // Not found
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
                return true;
            }
            // Display list forward
            public void displayForward() {
                if (head == null) {
                    System.out.println("List is empty.");
                    return;
                }
                Node temp = head;
                System.out.print("Forward: ");
                while (temp != null) {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
                System.out.println();
            }
            // Display list backward
            public void displayBackward() {
                if (head == null) {
                    System.out.println("List is empty.");
                    return;
                }
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                System.out.print("Backward: ");
                while (temp != null) {
                    System.out.print(temp.data + " ");
                    temp = temp.prev;
                }
                System.out.println();
            }
        }
    }
}
