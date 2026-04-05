package org.example.Neighbor;

import java.security.SecureRandom;
import java.util.*;

public class Person {
    String name;
    boolean isHuman;

    String hair;
    String eye;
    String mouth;
    String skin;
    String id_card;
    //========//
    IDCard id;

    // Generates a numeric ID of given length
    public static String generateID(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10)); // Digits 0-9
        }
        return sb.toString();
    }

    static String[] hairs = {"Black","Brown","Blue","Gray","Blonde"};
    static String[] eyes = {"Black","Brown","Blue","Gray","Yellow"};
    static String[] mouths = {"Small", "Big","Plum","Slim"};
    static String[] skins = {"Dark","Brown","Olive","White"};
    static String[] ID_card = {
            generateID(8),
            generateID(8),
            generateID(8),
            generateID(8),
            generateID(8)};

    Random r = new Random();
    // Construct Person/Alien
    public Person(String name, boolean isHuman) {
        this.name = name;
        this.isHuman = isHuman;

        // Real Person
        this.hair = hairs[r.nextInt(hairs.length)];
        this.eye = eyes[r.nextInt(eyes.length)];
        this.mouth = mouths[r.nextInt(mouths.length)];
        this.skin = skins[r.nextInt(skins.length)];
        this.id_card = ID_card[r.nextInt(ID_card.length)];
        // Real Human
        if (isHuman) {
            // Everything is checked
            id = new IDCard(name, hair, eye, mouth, skin, id_card);
        }
        // Alien
        else {
            // At least one flaw
            String fakeHair = hair;
            String fakeEyes = eye;
            String fakeMouth = mouth;
            String fakeSkin = skin;
            String fakeID = id_card;

            int wrong = r.nextInt(5);

            if (wrong == 0) {
                fakeHair = getDifferent(hairs, hair);
            } else if (wrong == 1) {
                fakeEyes = getDifferent(eyes, eye);
            } else if (wrong == 2) {
                fakeMouth = getDifferent(mouths, mouth);
            } else if (wrong == 3) {
                fakeSkin = getDifferent(skins, skin);
            } else if (wrong == 4) {
                fakeID = getDifferent(ID_card, id_card);
            }

            id = new IDCard(name, fakeHair, fakeEyes, fakeMouth,fakeSkin, fakeID);
        }
    }

    // Random Function
    private String getDifferent(String[] arr, String current) {
        String value;
        do {
            value = arr[r.nextInt(arr.length)];
        } while (value.equals(current));
        return value;
    }

    public String getName() {
        return name;
    }
    public boolean isHuman() {
        return isHuman;
    }
    public String getHair() {
        return hair;
    }
    public String getEye() {
        return eye;
    }
    public String getMouth() {
        return mouth;
    }
    public String getSkin() {
        return skin;
    }
    public String getIdCard() {
        return id_card;
    }
    public IDCard getId() {
        return id;
    }
}
