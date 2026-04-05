package org.example;

import org.example.Neighbor.*;
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
    public static void Gate() {
        Object b = Door();
        if (b == null) {
            System.out.println("ERROR: INVALID GATE");
        } else {
            if ((boolean) b){
                System.out.println("Gate Open");
            }
            else{
                System.out.println("Gate Closed");
            }
        }
    }

    public static String Species(Person person) {
        if (person.isHuman()) {
            return "Human";
        } else {
            return "Alien";
        }
    }

    public static void Check(Person person) {
        System.out.println("What do you want to do?");

        while (true) {
            System.out.println(person.getName());
            System.out.println("\n--- Check? ---");
            System.out.println("1. Check Mouth: Mouth");
            System.out.println("2. Check Eye: Eye");
            System.out.println("3. Check Hair: Hair");
            System.out.println("4. Check Skin: Skin");
            System.out.println("5. Id Number: ID");
            System.out.println("5. Return");
            System.out.print("\nEnter choice by name: ");

            String choice;
            if (!sc.hasNextLine()) {
                System.out.println("What are you doing?");
                sc.next();
                continue;
            }
            choice = sc.nextLine();
            switch (choice.toLowerCase()) {
                case "mouth": System.out.println("Mouth: " + person.getMouth());
                break;
                case "eye": System.out.println("Eye: " + person.getEye());
                break;
                case "hair": System.out.println("Hair: " + person.getHair());
                break;
                case "skin": System.out.println("Skin: " + person.getSkin());
                break;
                case "id": System.out.println("ID_Number: " + person.getId());
                break;
                case "return": return;
            }
        }
    }

    public static void call(Person person) {
        System.out.println("Calling...");
        if (person.isHuman()) {
            System.out.println("📞 Someone picked up!");
        } else {
            System.out.println("📞 No answer...");
        }
    }

    public static void showDoc(Person person) {
        System.out.println("---- ID CARD ----");
        System.out.println("Name: " + person.getName());
        System.out.println("Hair: " +person.getHair());
        System.out.println("Eyes: " + person.getEye());
        System.out.println("Mouth: " + person.getMouth());
        System.out.println("Skin: " + person.getSkin());
        System.out.println("ID: " + person.getIdCard());
        System.out.println("-----------------");
    }
    public static void Queue(Queue<Person> human) {
        for (Person person : human) {
            System.out.println(person.getName());
        }
    }
}

