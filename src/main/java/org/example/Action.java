package org.example;

import java.util.*;

public class Action {
    static Scanner sc = new Scanner(System.in);

    public static Object Door() {
        System.out.print("Open / Close: ");
        String act = sc.nextLine();
        return switch (act.toLowerCase()) {

            case "open" -> true;
            case "close" -> false;
            default -> null;
        };
    }
    //Open or Close then return Human to the stack
    public static void Gate(Sll queue) {
        Stack<Human> stack = new Stack<>();
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
        stack.add(queue.dequeue());
        queue.display();
    }

    public static void Check(Human h) {
        System.out.println("What do you want to do?");

        while (true) {
            System.out.println("\n--- Check? ---");
            System.out.println("1. Mouth");
            System.out.println("2. Eye");
            System.out.println("3. Hair");
            System.out.println("4. Exit");
            System.out.print("Enter choice by name: ");

            String choice;
            if (!sc.hasNextLine()) {
                System.out.println("What are you doing?");
                sc.next();
                continue;
            }
            choice = sc.nextLine();
            switch (choice.toLowerCase()) {
                case "mouth": System.out.println("Mouth: " + h.getMouth());
                break;
                case "eye": System.out.println("Eye: " + h.getEye());
                break;
                case "hair": System.out.println("Hair: " + h.getHair());
                break;
                case "exit": return;
            }
        }
    }

    public static void PhoneCall(Human h) {
        if (h.getPhone_call() != true) {
            System.out.println("Calling " + h.getName());
            System.out.println("I am home.");
        }else {
            System.out.println("Calling " + h.getName()+"...");
            System.out.println("No one pick up your call.");
        }
    }

    public static void Id_card(Human h) {
        if (h.getId_card() == true) {
            System.out.println("ID card identify");
        }else  {
            System.out.println("ID card is faulty");
        }
    }
}

