package org.example;

import org.example.List.*;
import org.example.Neighbor.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        Script mss = new Script ();

        Cll action = new Cll();
        Sll log = new Sll();
        Dll scoreList = new Dll();

        // Conversation


        // Neighbors
        ArrayList<Person> humans = new ArrayList<>();
        ArrayList<Person> aliens = new ArrayList<>();

        humans.add(new Person("John", true));
        humans.add(new Person("Alice", true));
        humans.add(new Person("Mike", true));
        humans.add(new Person("Sarah", true));
        humans.add(new Person("David", true));

        aliens.add(new Person("John", false));
        humans.add(new Person("Alice", false));
        aliens.add(new Person("Mike", false));
        aliens.add(new Person("Sarah", false));
        aliens.add(new Person("David", false));

        // Neighbor Line
        Collections.shuffle(humans);
        Collections.shuffle(aliens);

        ArrayList<Person> selected = new ArrayList<>();

        // 3 human
        for (int i = 0; i < 3; i++) {
            selected.add(humans.get(i));
        }
        // 2 imposter
        for (int i = 0; i < 2; i++) {
            selected.add(aliens.get(i));
        }

        Collections.shuffle(selected);
        Queue<Person> queue = new ArrayDeque<>(selected);

        int score = 0;
        int alienPassed = 0;
        int round = 1;

        System.out.println("\n=================");
        System.out.println("Round: " + round + "/5");

        // Gameplay window
        while (!queue.isEmpty()) {
            Person p = (Person) queue.poll();

            // Actions
            action.append("Check",() -> Action.Check(p));
            action.append("ID Document",() -> Action.showDoc(p));
            action.append("House Call",() -> Action.call(p));
            action.append("Gate", Action::Gate);
            action.append("Queue", () -> Action.Queue(queue));

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
                    if (action.methodName().equals("Gate")) {
                        if (p.isHuman()) {
                            score++;
                        } else {
                            score--;
                            alienPassed++;
                        }
                        log.add(p.getName() + " is a " + Action.Species(p));
                    }
                    break;
                case "leave":
                    System.out.println("Exiting...");
                    System.out.println("You quited your job...:<");
                    sc.close();
                    return;
                default:
                    System.out.println("ERROR: Invalid input.");
            }
            scoreList.add(score);
            round++;
        }
        System.out.println("\n=================");
        if (alienPassed==0 && round > 5) {
            System.out.println(" Congratulations! You have complete the day!.");
        } else if (alienPassed>=2 && round > 5) {
            System.out.println(" YOU LOSE! Aliens have invaded!");
        }

        System.out.println("Final Score: " + score);
        System.out.println("\nLog:");
        log.print();

        System.out.println("\nScore History:");
        scoreList.print();
    }
}
