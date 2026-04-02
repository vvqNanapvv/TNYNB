package org.example;

import java.util.*;

public class Human extends Attribute{
    static Random rand = new Random();

    Object[] people = {John(),Kyle()};

    static String [] EYE = {"Black","Brown","Blue","Green"};
    static String [] MOUTH = {"Big","Slim","Thin"};
    static String [] HAIR = {"Black","Brown","Grey","White"};

    public Object John() {

        setName("John Tennyson");
        setEye(EYE[rand.nextInt(EYE.length)]);
        setMouth(MOUTH[rand.nextInt(MOUTH.length)]);
        setHair(HAIR[rand.nextInt(HAIR.length)]);

        System.out.println("Name: " + getName()
                + "\n Eye: " + getEye()
                + "\n Mouth: " + getMouth()
                + "\n Hair: " + getHair());

        return "";
    }

    public Object Kyle() {

        setName("Kyle Tenon");
        setEye(EYE[rand.nextInt(EYE.length)]);
        setMouth(MOUTH[rand.nextInt(MOUTH.length)]);
        setHair(HAIR[rand.nextInt(HAIR.length)]);

        System.out.println("Name: " + getName()
                + "\n Eye: " + getEye()
                + "\n Mouth: " + getMouth()
                + "\n Hair: " + getHair());

        return "";
    }
}
