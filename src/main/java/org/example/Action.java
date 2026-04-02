package org.example;

import java.util.*;

public class Action {

    static Scanner sc = new Scanner(System.in);

    //Circling Method
    public static class Cll {
        static class Node {
            Object data;
            Node next;

            public Node(Object data) {
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

        // Inserting Method at the end of the list
        public void append(Object data) {
            Node Method = new Node(data);
            if (head == null) {
                head = Method;
                tail = Method;
                tail.next = head;

                return;
            }
            tail.next = Method;
            tail = Method;
            tail.next = head;
        }

        // Moving to the next Method
        public void moveNext() {
            Node current = head;
            head = head.next;

            System.out.println(current.data.toString());
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

    public static Object Check(Object h) {
        return h;
    }
}

