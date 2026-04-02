package org.example;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public void main(String[] args) {

        Human h = new Human();
        h.John();
        h.Kyle();
        //just placeholder for now

        Action.Cll cll = new Action.Cll();
        cll.append((Method) Action.Gate);
        cll.append((Method) Action.Check(h)); // not sure what this'll do honestly :/

        Scanner sc = new Scanner(System.in);

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
                    cll.moveNext();
                    break;
                case 2:
                    cll.display();
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
