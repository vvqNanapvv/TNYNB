package org.example;

import org.example.linkedlist.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        Human[] people = new Human[5];
        Attribute att = new Attribute();
        Cll action = new Cll();
        Sll line = new Sll();
        Dll data = new Dll("",45);
        Deque<Human> q = new ArrayDeque<>(5);
        Stack<Human> p = new Stack<>();

        // Neighbors
        Human John = new Human("John Smith",
                att.Identity[rand.nextInt(att.Identity.length)],
                att.Mouth[rand.nextInt(att.Mouth.length)],
                att.Eye[rand.nextInt(att.Eye.length)],
                att.Hair[rand.nextInt(att.Hair.length)],
                att.Id_card[rand.nextInt(att.Id_card.length)],
                att.Phone_call[rand.nextInt(att.Phone_call.length)]);

        Human Jane = new Human("Jane Skyler", att.Identity[rand.nextInt(att.Identity.length)]);
        if (Jane.getIdentity().equals("true")) {
            Jane.setMouth(att.Mouth[rand.nextInt(att.Mouth.length)]);
            Jane.setEye(att.Eye[rand.nextInt(att.Eye.length)]);
            Jane.setHair(att.Hair[rand.nextInt(att.Hair.length)]);
            Jane.setPhone_call(att.Phone_call[0]);
        }else{
            Jane.setMouth(att.alienMouth[rand.nextInt(att.alienMouth.length)]);
            Jane.setEye(att.alienEye[rand.nextInt(att.alienEye.length)]);
            Jane.setHair(att.alienHair[rand.nextInt(att.alienHair.length)]);
            Jane.setPhone_call(att.Phone_call[rand.nextInt(att.Phone_call.length)]);
        }   Jane.setId_card(att.Id_card[rand.nextInt(att.Id_card.length)]);

        Human Kate = new Human("Kate Benjamin", att.Identity[rand.nextInt(att.Identity.length)]);
        if (Kate.getIdentity().equals("true")) {
            Kate.setMouth(att.Mouth[rand.nextInt(att.Mouth.length)]);
            Kate.setEye(att.Eye[rand.nextInt(att.Eye.length)]);
            Kate.setHair(att.Hair[rand.nextInt(att.Hair.length)]);
            Kate.setPhone_call(att.Phone_call[0]);
        }else{
            Kate.setMouth(att.alienMouth[rand.nextInt(att.alienMouth.length)]);
            Kate.setEye(att.alienEye[rand.nextInt(att.alienEye.length)]);
            Kate.setHair(att.alienHair[rand.nextInt(att.alienHair.length)]);
            Kate.setPhone_call(att.Phone_call[rand.nextInt(att.Phone_call.length)]);
        }   Kate.setId_card(att.Id_card[rand.nextInt(att.Id_card.length)]);

        // Neighbor Line

        int position = 0;
        people[0] = John;
        people[1] = Jane;
        people[2] = Kate;
        q.add(people[0]);
        q.add(people[1]);
        q.add(people[2]);


        // Actions
        action.append("Check",() -> Action.Check(people[position]));
        action.append("Id-Card",() -> Action.Id_card(people[position]));
        action.append("Phone-Call",() -> Action.PhoneCall(people[position]));
        action.append("Gate",() -> Action.Gate(q,p));
        action.append("Queue",() -> Action.Queue(q));

        // Gameplay window
        while (!q.isEmpty()) {
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
                    System.out.println();
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
        // Check condition to win
        for (int i = p.size() - 1; i >= 0; i--) {
            int y=0;
            if(p.get(i).getIdentity() == "false"){
                y++;
                if(y>=2){
                    System.out.println("You have failed your neighbor :[");
                }
            }
        }
    }
}
