package org.game;

public class IDCard {
    String name;
    String hair;
    String eyes;
    String mouth;

    public IDCard(String name, String hair, String eyes, String mouth) {
        this.name = name;
        this.hair = hair;
        this.eyes = eyes;
        this.mouth = mouth;
    }

    public void show() {
        System.out.println("---- ID CARD ----");
        System.out.println("Name: " + name);
        System.out.println("Hair: " + hair);
        System.out.println("Eyes: " + eyes);
        System.out.println("Mouth: " + mouth);
        System.out.println("-----------------");
    }
}