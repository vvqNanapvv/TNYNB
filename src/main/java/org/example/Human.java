package org.example;

import java.util.*;

public class Human {
    static Random rand = new Random();

    static String [] eye = {"Black","Brown","Blue","Green"};
    static String [] mouth = {"Big","Slim","Thin"};
    static String [] hair = {"Black","Brown","Grey","White"};

    public static class human extends Attribute{
        public Objects John() {
            setName("John Smith");
            System.out.println(getName());

            setHair(hair[rand.nextInt(hair.length)]);
            System.out.println("Hair: "+getHair());

            setMouth(mouth[rand.nextInt(mouth.length)]);
            System.out.println("Mouth: "+getMouth());

            setEye(eye[rand.nextInt(eye.length)]);
            System.out.println("Eye: "+getEye());

            setId_card(rand.nextBoolean());
            if (isId_card()){
                System.out.println("Id card Check");
            }
            else System.out.println("Id card Not Check");
            return null;
        }
        public Objects Kyle() {
            setName("Kyle Tenon");
            System.out.println(getName());

            setHair(hair[rand.nextInt(hair.length)]);
            System.out.println("Hair: "+getHair());

            setMouth(mouth[rand.nextInt(mouth.length)]);
            System.out.println("Mouth: "+getMouth());

            setEye(eye[rand.nextInt(eye.length)]);
            System.out.println("Eye: "+getEye());

            setId_card(rand.nextBoolean());
            if (isId_card()){
                System.out.println("Id card Check");
            }
            else System.out.println("Id card Not Check");
            return null;
        }
    }
}
