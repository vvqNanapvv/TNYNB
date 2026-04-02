package org.example;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Action.Cll cll = new Action.Cll();
        cll.append((Method) Action.Gate);
        cll.display();

        Human.human h = new Human.human();
        h.John();
        h.Kyle();
        //just placeholder

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Action Menu ---");
            System.out.println("1. Door");
            System.out.println("2. Check");
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
                    Action.Gate();
                    break;
                case 2:
                    Action.Check();
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
