package org.example;

import java.lang.reflect.Method;
import java.util.*;

public class Action {
    public static Object Gate;
    public static Object Check;
    //Object Methods

    static Scanner sc = new Scanner(System.in);

    public static class Cll {
        static class Node {
            Method data;
            Node next;

            public Node(Method data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node head;
        private Node tail;
        public Cll() {
            head = null;
            tail = null;
        }

        // Inserting a node at the end of the list
        public void append(Method data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                tail.next = head;
                return;
            }
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

        // Moving to the next node
        public String moveNext() {
            Node current = head;
            head = head.next;
            current.next = current.next.next;

            return head.data.toString();
        }

        // Display the list
        public Node display() {
            Node current = head;
                if (head == null) {
                    System.out.println("List is empty.");
            }   else {
                    return current;
            }
            return null;
        }
}

    public static Object Door() {
        System.out.print("Open / Close: ");
        String act = sc.nextLine();
        return switch (act.toLowerCase()) {

            case "open" -> true;
            case "close" -> false;
            default -> null;
        };
    }

    public static Object Gate() {
        Object b = Door();
        if (b == null) {
            System.out.println("ERROR: INVALID GATE");
            return Gate();
        }
        else {
            if ((boolean) b){
                System.out.println("Gate Open");
            }
            else{
                System.out.println("Gate Closed");
            }
        } return "";
    }

    public static Object Check(Human s) {
        s = new Human();
        return s;
    }
}

