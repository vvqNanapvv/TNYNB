package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Action.Cll cll = new Action.Cll();

        Random rand = new Random();
        Attribute att = new Attribute();

        Human John = new Human("John Smith",
                att.Mouth[rand.nextInt(att.Mouth.length)],
                att.Eye[rand.nextInt(att.Eye.length)],
                att.Hair[rand.nextInt(att.Hair.length)],
                att.Id_card[rand.nextInt(att.Id_card.length)],
                att.Phone_call[rand.nextInt(att.Id_card.length)]);

        Human Jane = new Human("Jane Skyler",
                att.Mouth[rand.nextInt(att.Mouth.length)],
                att.Eye[rand.nextInt(att.Eye.length)],
                att.Hair[rand.nextInt(att.Hair.length)],
                att.Id_card[rand.nextInt(att.Id_card.length)],
                att.Phone_call[rand.nextInt(att.Id_card.length)]);

        Human[] people = new Human[4];

        people[0] = John;
        people[1] = Jane;

        cll.append("Check",() -> Action.Check(people[0]));
        cll.append("Id-Card",() -> Action.Id_card(people[0]));
        cll.append("Phone-Call",() -> Action.PhoneCall(people[0]));
        cll.append("Gate", Action::Gate);

        while (true) {
            System.out.println("\n--- Action Menu ---");
            System.out.println("1. Next Action");
            System.out.println("2. Act");
            System.out.println("3. Exit");
            System.out.println("Action: " + cll.methodName());
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
                    cll.rotate(1);
                    System.out.println("Action: " + cll.methodName());
                    break;
                case 2:
                    System.out.println("Execute: " + cll.methodName());
                    System.out.println("");
                    cll.executeAt();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("ERROR: Invalid input.");
            }
        }
    }
}
