package org.game;

import java.util.Random;

public class Person {
    String name;
    boolean isHuman;

    String hair;
    String eyes;
    String mouth;

    IDCard id;

    static String[] hairs = {"Black", "Brown", "Blonde"};
    static String[] eyesList = {"Blue", "Black", "Green"};
    static String[] mouths = {"Small", "Big"};

    Random r = new Random();

    public Person(String name, boolean isHuman) {
        this.name = name;
        this.isHuman = isHuman;

        // 🎭 ลักษณะจริง
        this.hair = hairs[r.nextInt(hairs.length)];
        this.eyes = eyesList[r.nextInt(eyesList.length)];
        this.mouth = mouths[r.nextInt(mouths.length)];

        // 🪪 ID
        if (isHuman) {
            // ✔ ตรง 100%
            id = new IDCard(name, hair, eyes, mouth);
        } else {
            // 👽 Alien → ผิด 1 จุดแบบเนียน
            String fakeHair = hair;
            String fakeEyes = eyes;
            String fakeMouth = mouth;

            int wrong = r.nextInt(3);

            if (wrong == 0) {
                fakeHair = getDifferent(hairs, hair);
            } else if (wrong == 1) {
                fakeEyes = getDifferent(eyesList, eyes);
            } else {
                fakeMouth = getDifferent(mouths, mouth);
            }

            id = new IDCard(name, fakeHair, fakeEyes, fakeMouth);
        }
    }

    // 🔥 ฟังก์ชันสุ่มค่า "ที่ไม่ซ้ำของเดิม"
    private String getDifferent(String[] arr, String current) {
        String value;
        do {
            value = arr[r.nextInt(arr.length)];
        } while (value.equals(current));
        return value;
    }

    public void showBasic() {
        System.out.println("Name: " + name);
    }

    public void checkAppearance() {
        System.out.println("Real Appearance:");
        System.out.println("Hair: " + hair);
        System.out.println("Eyes: " + eyes);
        System.out.println("Mouth: " + mouth);
    }

    public void showID() {
        id.show();
    }

    public void call() {
        System.out.println("Calling...");
        if (isHuman) {
            System.out.println("📞 Someone picked up!");
        } else {
            System.out.println("📞 No answer...");
        }
    }
}