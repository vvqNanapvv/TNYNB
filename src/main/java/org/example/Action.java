package org.example;

import com.sun.source.tree.WhileLoopTree;

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
        public Object moveNext() {
            Node current = head;
            head = head.next;

            return current;
        }

        public Object getHead() {
            return head;
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
            Gate();
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

    public static Object Check(Human h) {
        System.out.println("Checking " + h.getName());
        System.out.println("Mouth: " + h.getMouth());
        System.out.println("Eye: " + h.getEye());
        System.out.println("Hair: " + h.getHair());
        return "";
    }

    public static Object PhoneCall(Human h) {
        if (h.getPhone_call() == "true") {
            System.out.println("Calling " + h.getName());
            System.out.println("I am home.");
        }else {
            System.out.println("Calling " + h.getName()+"...");
            System.out.println("No one pick up your call.");
        }
        return "";
    }

    public static Object Id_card(Human h) {
        if (h.getId_card() == "true") {
            System.out.println("ID card identify");
        }else  {
            System.out.println("ID card is faulty");
        }
        return "";
    }
}

