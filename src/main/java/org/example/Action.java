package org.example;

import java.util.*;

public class Action {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        String methodName;
        Runnable task; // Store a method as Runnable
        Node next;

        public Node(String methodName,Runnable task) {
            this.methodName = methodName;
            this.task = task;
            this.next = null;
        }
    }
    // Circular linked list class for Methods
    static class Cll {
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
        public void append(String methodName,Runnable task) {
            Node newNode = new Node(methodName,task);
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

    public static Object Door() {
        System.out.print("Open / Close: ");
        String act = sc.nextLine();
        return switch (act.toLowerCase()) {

            case "open" -> true;
            case "close" -> false;
            default -> null;
        };
    }

    public static void Gate() {
        Object b = Door();
        if (b == null) {
            System.out.println("ERROR: INVALID GATE");
        }
        else {
            if ((boolean) b){
                System.out.println("Gate Open");
            }
            else{
                System.out.println("Gate Closed");
            }
        }
    }

    public static void Check(Human h) {
        System.out.println("Checking " + h.getName());
        System.out.println("Mouth: " + h.getMouth());
        System.out.println("Eye: " + h.getEye());
        System.out.println("Hair: " + h.getHair());
    }

    public static void PhoneCall(Human h) {
        if (Objects.equals(h.getPhone_call(), "true")) {
            System.out.println("Calling " + h.getName());
            System.out.println("I am home.");
        }else {
            System.out.println("Calling " + h.getName()+"...");
            System.out.println("No one pick up your call.");
        }
    }

    public static void Id_card(Human h) {
        if (Objects.equals(h.getId_card(), "true")) {
            System.out.println("ID card identify");
        }else  {
            System.out.println("ID card is faulty");
        }
    }
}

