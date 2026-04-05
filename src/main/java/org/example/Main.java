package org.example;

import org.example.linkedlist.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        Attribute att = new Attribute();
        Script mss = new Script ();

        Cll action = new Cll();
        Sll line = new Sll();

        Queue<Human> q = new ArrayDeque<>(5);
        Stack<Human> p = new Stack<>();

        // Traits
        line.addMessage(mss.mss_1[rand.nextInt(mss.mss_1.length)]);


        // Neighbors
        Human John = new Human("John Smith", att.Identity[rand.nextInt(att.Identity.length)]);
        if (John.getIdentity().equals("true")) {
            John.setMouth(att.Mouth[rand.nextInt(att.Mouth.length)]);
            John.setEye(att.Eye[rand.nextInt(att.Eye.length)]);
            John.setHair(att.Hair[rand.nextInt(att.Hair.length)]);
            John.setPhone_call(att.Phone_call[0]);
        }else{
            John.setMouth(att.alienMouth[rand.nextInt(att.alienMouth.length)]);
            John.setEye(att.alienEye[rand.nextInt(att.alienEye.length)]);
            John.setHair(att.alienHair[rand.nextInt(att.alienHair.length)]);
            John.setPhone_call(att.Phone_call[rand.nextInt(att.Phone_call.length)]);
        }   John.setId_card(att.Id_card[rand.nextInt(att.Id_card.length)]);

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
        q.add(John);
        q.add(Jane);
        q.add(Kate);
        q = shuffleQueue(q);
        Queue<Human> shuffleQ = q;

        Human[] people = {shuffleQ.poll(), shuffleQ.poll(),shuffleQ.poll()};

        // Actions
        action.append("Check",() -> Action.Check(people[0]));
        action.append("Talk", line::displayTrait);
        action.append("Id-Card",() -> Action.Id_card(people[0]));
        action.append("Phone-Call",() -> Action.PhoneCall(people[0]));
        action.append("Gate",() -> Action.Gate(shuffleQ,p));
        action.append("Queue",() -> Action.Queue(shuffleQ));

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
            if(Objects.equals(p.get(i).getIdentity(), "false")){
                y++;
                if(y>=2){
                    System.out.println("You have failed your neighbor :[");
                }
            }
        }
    }
    public static <T> Queue<T> shuffleQueue(Queue<T> queue) {
        if (queue == null || queue.isEmpty()) {
            return new LinkedList<>();
        }

        // Convert queue to list
        List<T> list = new ArrayList<>(queue);

        // Shuffle the list
        Collections.shuffle(list);

        // Create a new queue from the shuffled list
        return new LinkedList<>(list);
    }
}
