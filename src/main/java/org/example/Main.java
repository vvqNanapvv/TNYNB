package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Human human = new Human();

        Object[] person = human.people;

        Action.Check(person[rand.nextInt(person.length)]);

        Action.Cll cll = new Action.Cll();
        cll.append(Action.Gate());

        while (true) {

            System.out.println("\n--- Action Menu ---");
            System.out.println("1. Next");
            System.out.println("2. Display");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice;
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                continue;
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
