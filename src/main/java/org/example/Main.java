package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

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

        Action.Check(people[0]);
        System.out.println(" ");
        Action.Check(people[1]);
        Action.PhoneCall(people[0]);
        Action.Id_card(people[0]);

        Action.Cll cll = new Action.Cll();
        cll.append(Action.Id_card(people[0]));

        /*while (true) {

            System.out.println("\n--- Action Menu ---");
            System.out.println("1. Next");
            System.out.println("2. Act");
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
                    cll.getHead();
                    sc.close();
                    return;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }*/
    }
}
