package org.example;

import java.util.*;

public class Human {
    static Random rand = new Random();

    static String [] eye = {"Black","Brown","Blue","Green"};
    static String [] mouth = {"Big","Slim","Thin"};
    static String [] hair = {"Black","Brown","Grey","White"};

    public static class John extends Attribute{
        public John() {
            setName("John Smith");
            setHair(setHair(hair[rand.nextInt(hair.length)]));
            setMouth(mouth[rand.nextInt(mouth.length)]);
            setEye(eye[rand.nextInt(eye.length)]);
        }
    }

    public static class Kyle extends Attribute{
        public Kyle() {
            setName("Kyle Tenon");
            setHair(setHair(hair[rand.nextInt(hair.length)]));
            setMouth(mouth[rand.nextInt(mouth.length)]);
            setEye(eye[rand.nextInt(eye.length)]);
        }
    }
}
