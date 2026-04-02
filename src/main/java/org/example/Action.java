package org.example;

import java.lang.reflect.Method;
import java.util.*;

public class Action {
    public static Object Gate;
    public static Object Check;

    static Scanner sc = new Scanner(System.in);

    static class Node {
        Method data;
        Node next;

        public Node(Method data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Cll {
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
        public void moveNext() {
            Node current = head;
            head = head.next;
            current.next = current.next.next;
        }

        // Display the list
        public void display() {
            Node current = head;
            if (head == null) {
                System.out.println("List is empty.");
            }
            else{
                System.out.print(current);
            }
        }
    }


    public static Object Door() {
        System.out.print("Open / Close: ");
        String act = sc.nextLine();
        boolean b;
        return switch (act.toLowerCase()) {

            case "open" -> b = true;
            case "close" -> b = false;
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
        }
        return "";
    }

    public static Objects Check() {
        Human h = new Human();

        return h.John();
    }
}

