package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();


        Cll action = new Cll();
        Attribute att = new Attribute();
        Sll queue = new Sll();
        // Neighbors
        Human John = new Human("John Smith", att.Identity[rand.nextInt()]);
        if(John.getIdentity()==true) {
            John.setEye(att.Eye[rand.nextInt(att.Eye.length)]);
            John.setMouth(att.Mouth[rand.nextInt(att.Mouth.length)]);
            John.setHair(att.Hair[rand.nextInt(att.Hair.length)]);
        } else {
            John.setEye(att.alienEye[rand.nextInt(att.alienEye.length)]);
            John.setMouth(att.alienMouth[rand.nextInt(att.alienMouth.length)]);
            John.setHair(att.alienHair[rand.nextInt(att.alienHair.length)]);}
        John.setId_card(att.Id_card[rand.nextInt(att.Id_card.length)]);
        John.setPhone_call(John.getIdentity());

        Human Jane = new Human("Jane Skyler", att.Identity[rand.nextInt()]);
        if(Jane.getIdentity()==true) {
            Jane.setEye(att.Eye[rand.nextInt(att.Eye.length)]);
            Jane.setMouth(att.Mouth[rand.nextInt(att.Mouth.length)]);
            Jane.setHair(att.Hair[rand.nextInt(att.Hair.length)]);
        } else {
            Jane.setEye(att.alienEye[rand.nextInt(att.alienEye.length)]);
            Jane.setMouth(att.alienMouth[rand.nextInt(att.alienMouth.length)]);
            Jane.setHair(att.alienHair[rand.nextInt(att.alienHair.length)]);}
        Jane.setId_card(att.Id_card[rand.nextInt(att.Id_card.length)]);
        Jane.setPhone_call(Jane.getIdentity());

        Human Kate = new Human("Kate Benjamin", att.Identity[rand.nextInt()]);
        if(Kate.getIdentity()==true) {
            Kate.setEye(att.Eye[rand.nextInt(att.Eye.length)]);
            Kate.setMouth(att.Mouth[rand.nextInt(att.Mouth.length)]);
            Kate.setHair(att.Hair[rand.nextInt(att.Hair.length)]);
        } else {
            Kate.setEye(att.alienEye[rand.nextInt(att.alienEye.length)]);
            Kate.setMouth(att.alienMouth[rand.nextInt(att.alienMouth.length)]);
            Kate.setHair(att.alienHair[rand.nextInt(att.alienHair.length)]);}
        Kate.setId_card(att.Id_card[rand.nextInt(att.Id_card.length)]);
        Kate.setPhone_call(Kate.getIdentity());

        // Neighbor Line
        Human[] people = new Human[4];
        int line = 0;
        people[0] = John;
        people[1] = Jane;
        people[2] = Kate;
        queue.enqueue(1,people[people.length-1]);
        queue.enqueue(2,people[people.length-1]);
        queue.enqueue(3,people[people.length-1]);

        // Actions
        action.append("Check",() -> Action.Check(people[line]));
        action.append("Id-Card",() -> Action.Id_card(people[line]));
        action.append("Phone-Call",() -> Action.PhoneCall(people[line]));
        action.append("Queue", queue::display);
        action.append("Gate", () -> Action.Gate(queue));

        // Gameplay window
        while (!queue.isEmpty()) {
            System.out.println("\n--- Action Menu ---");
            System.out.println("1. Next: Action");
            System.out.println("2. Act");
            System.out.println("3. Leave..?");
            System.out.println("\nAction: " + action.methodName());
            System.out.print("\nEnter choice by name: ");

            String choice;
            if (!sc.hasNextLine()) {
                System.out.println("What are you doing?");
                sc.next();
                continue;
            }
            choice = sc.nextLine();

            switch (choice.toLowerCase()) {
                case "next":
                    action.rotate(1);
                    break;
                case "act":
                    System.out.println("Execute: " + action.methodName());
                    System.out.println("");
                    action.executeAt();
                    break;
                case "leave":
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("ERROR: Invalid input.");
            }
        }


    }
}
