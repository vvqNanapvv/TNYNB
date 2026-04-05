package org.game;

import org.game.list.*;

import java.util.*;
import java.util.Queue;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Sll log = new Sll();
        Dll scoreList = new Dll();

        // สร้างตัวละคร (ไม่ซ้ำ)
        ArrayList<Person> humans = new ArrayList<>();
        ArrayList<Person> aliens = new ArrayList<>();

        humans.add(new Person("John", true));
        humans.add(new Person("Alice", true));
        humans.add(new Person("Mike", true));
        humans.add(new Person("Sarah", true));
        humans.add(new Person("David", true));

        aliens.add(new Person("John", false));
        aliens.add(new Person("Mike", false));
        aliens.add(new Person("Sarah", false));
        aliens.add(new Person("David", false));

        Collections.shuffle(humans);
        Collections.shuffle(aliens);

        ArrayList<Person> selected = new ArrayList<>();

        // 3 คน
        for (int i = 0; i < 3; i++) {
            selected.add(humans.get(i));
        }

        // 2 คน
        for (int i = 0; i < 2; i++) {
            selected.add(aliens.get(i));
        }

        Collections.shuffle(selected);

        Queue queue = new ArrayDeque(selected);

        int score = 0;
        boolean alienPassed = false;
        int round = 1;

        while (!queue.isEmpty()) {
            Person p = (Person) queue.poll();

            System.out.println("\n=================");
            System.out.println("Round: " + round + "/5");
            p.showBasic();

            boolean decided = false;

            while (!decided) {
                System.out.println("\n1. Open");
                System.out.println("2. Close");
                System.out.println("3. Check ID");
                System.out.println("4. Call");
                System.out.println("5. Check Appearance");

                System.out.print("Choose: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        if (p.isHuman) {
                            System.out.println("/ Human allowed.");
                            score++;
                            log.add(p.name + " allowed");
                        } else {
                            System.out.println("X Alien ENTERED!");
                            score--;
                            log.add(p.name + " alien passed");
                            alienPassed = true;
                        }
                        decided = true;
                        break;

                    case 2:
                        if (!p.isHuman) {
                            System.out.println("/ Alien blocked.");
                            score++;
                            log.add(p.name + " blocked");
                        } else {
                            System.out.println("X Human rejected.");
                            score--;
                            log.add(p.name + " rejected");
                        }
                        decided = true;
                        break;

                    case 3:
                        p.showID();
                        break;

                    case 4:
                        p.call();
                        break;

                    case 5:
                        p.checkAppearance();
                        break;

                    default:
                        System.out.println("Invalid");
                }
            }

            scoreList.add(score);
            System.out.println("Score: " + score);

            if (alienPassed) {
                System.out.println("\n GAME OVER (Alien infiltrated!)");
                break;
            }

            round++;
        }

        System.out.println("\n=================");
        if (!alienPassed && round > 5) {
            System.out.println(" YOU WIN! No alien entered!");
        }

        System.out.println("Final Score: " + score);

        System.out.println("\nLog:");
        log.print();

        System.out.println("\nScore History:");
        scoreList.print();
    }
}