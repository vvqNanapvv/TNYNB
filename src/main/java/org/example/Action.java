package org.example;

import org.example.Neighbor.*;
import java.util.*;

public class Action {
    static Scanner sc = new Scanner(System.in);
    // Return boolean or null
    public static Object Door() {
        System.out.print("Open / Close: ");
        String act = sc.nextLine();
        return switch (act.toLowerCase()) {

            case "open" -> true;
            case "close" -> false;
            default -> null;
        };
    }
    // Input Door() to output text here.
    public static void Gate(Person person) {
        Object b = Door();
        if (b == null) {
            System.out.print("ERROR: Invalid");
        } else  {
            if (b.equals(true)) {
                System.out.println("Gate is open");
                System.out.println(person.getName() + " has been approved");
            }
            else {
                System.out.println("Gate is closed");
                System.out.println(person.getName() + " is restrained");
            }
        }
    }
    // Return specie: Human or Alien
    public static String Species(Person person) {
        if (person.isHuman()) {
            return "Human";
        } else {
            return "Alien";
        }
    }
    // Checking person: Choice
    public static void Check(Person person) {
        System.out.println("What do you want to do?");

        while (true) {
            System.out.println("\n--- Check? ---");
            System.out.println("1. Check Official Document: Document");
            System.out.println("2. Check Mouth: Mouth");
            System.out.println("3. Check Eye: Eye");
            System.out.println("4. Check Hair: Hair");
            System.out.println("5. Check Skin: Skin");
            System.out.println("6. Id Number: ID");
            System.out.println("7. Return");
            System.out.print("\nEnter choice by name: ");

            String choice;
            if (!sc.hasNextLine()) {
                System.out.println("What are you doing?");
                sc.next();
                continue;
            }
            choice = sc.nextLine();
            switch (choice.toLowerCase()) {
                case "document": showDoc(person);
                break;
                case "mouth": System.out.println("Mouth: " + person.getMouth());
                break;
                case "eye": System.out.println("Eye: " + person.getEye());
                break;
                case "hair": System.out.println("Hair: " + person.getHair());
                break;
                case "skin": System.out.println("Skin: " + person.getSkin());
                break;
                case "id": System.out.println("ID_Number: " + person.getIdCard());
                break;
                case "return": return;
                default: System.out.println("ERROR: Invalid input.");
            }
        }
    }
    // Phoning their house: Person at home or no?
    public static void Call(Person person) {
        System.out.println("Calling...");
        if (person.isHuman()) {
            System.out.println("📞 Someone picked up!");
        } else {
            System.out.println("📞 No answer...");
        }
    }
    // Return random script
    public static void Talk(Person person) {
        if (person.isHuman()) {
            System.out.println(Arrays.toString(person.getScript_H()));
        }else  {
            System.out.println(Arrays.toString(person.getScript_A()));
        }
    }
    // Show full document
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
    // How many in the queue
    public static void Queue(Queue<Person> human) {
        for (Person person : human) {
            System.out.println(person.getName());
        }
    }
}

