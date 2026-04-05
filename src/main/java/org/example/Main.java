package org.example;

import org.example.List.*;
import org.example.Neighbor.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Script mss = new Script ();

        Cll action = new Cll();
        Sll log = new Sll();
        Dll scoreList = new Dll();

        // Neighbor/Alein
        ArrayList<Person> humans = new ArrayList<>();
        ArrayList<Person> aliens = new ArrayList<>();

        humans.add(new Person("John Smith", true));
        humans.add(new Person("Alice Sunday", true));
        humans.add(new Person("Mike Mikey", true));
        humans.add(new Person("Sarah Kohlhase", true));
        humans.add(new Person("David Tenseness", true));

        aliens.add(new Person("John Smith", false));
        humans.add(new Person("Alice Sunday", false));
        aliens.add(new Person("Mike Mikey", false));
        aliens.add(new Person("Sarah Kohlhase", false));
        aliens.add(new Person("David Tenseness", false));

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
        // Shuffling
        Collections.shuffle(selected);
        Queue<Person> queue = new ArrayDeque<>(selected);

        int score = 0;
        int alienPassed = 0;
        int round = 1;
        boolean play = true;
        // Play AGAIN?
        while(play){
            // Gameplay window
            while (!queue.isEmpty()) {
                // People queue
                Person person = queue.peek();
                // Actions
                Person P = person;
                action.append("Check",() -> Action.Check(P));
                action.append("Full ID_Document",() -> Action.showDoc(P));
                action.append("House Call",() -> Action.Call(P));
                action.append("Gate", () -> Action.Gate(P));
                action.append("Queue", () -> Action.Queue(queue));

                System.out.println("\n=================");
                System.out.println("Round: " + round + "/5");
                Action.showDoc(person);

                System.out.println("\n--- Action Menu ---");
                System.out.println("1. Next");
                System.out.println("2. Act");
                System.out.println("3. Quit");
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
                        action.executeAt();
                        try {
                            // Pause for 3 seconds
                            System.out.println("Starting...");
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            // If were to interrupted
                            System.err.println();
                            Thread.currentThread().interrupt(); // Restore interrupt status
                        }
                        System.out.println();
                        if (action.methodName().equals("Gate")) {
                            // keep track of human and alien :>
                            if (person.isHuman()) {
                                score++;
                            } else {
                                score--;
                                alienPassed++;
                            }
                            person = queue.poll();
                            log.add(person.getName() + " is a " + Action.Species(person));
                            round++;
                        }
                        break;
                    case "quit":
                        System.out.println("Exiting...");
                        System.out.println("You quited your job...:<");
                        sc.close();
                        return;
                    default:
                        System.out.println("ERROR: Invalid input.");
                }
                scoreList.add(score);
            }
            System.out.println("\n=================");
            if (alienPassed==0 && round > 5) {
                System.out.println(" Congratulations! You have complete the day!.");
            } else if (alienPassed==2 && round > 5) {
                System.out.println(" YOU LOSE! Aliens have invaded!");
            }

            System.out.println("Final Score: " + score);
            System.out.println("\nLog:");
            log.print();

            System.out.println("\nScore History:");
            scoreList.printAll();
            System.out.println("\n=================");
            System.out.println("Want to play again?");
            if (sc.hasNextLine()) {
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    Collections.shuffle(humans);
                    Collections.shuffle(aliens);
                    Collections.shuffle(selected);

                    score = 0;
                    alienPassed = 0;
                    round = 1;
                }
                else if (answer.equalsIgnoreCase("no")) {
                    play = false;
                    sc.close();
                }
                else sc.nextLine();
            }
        }
    }
}
