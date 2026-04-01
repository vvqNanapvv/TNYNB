package org.example;
import java.util.*;

public class Attribute {
    private String name;
    private String mouth;
    private String eye;
    private String hair;
    private boolean Id_card;
    private boolean Phone_call;

    public void Character(String name){
        this.name = name;
        Random rand = new Random();
        String [] hair = {"Black","Brown","Grey","White"};
        String [] eye = {"Black","Brown","Blue","Green"};
        String [] mouth = {"Big","Slim","Thin"};

        // Random hair colour
        this.hair = hair[rand.nextInt(hair.length)];
        // Random eye colour
        this.eye = eye[rand.nextInt(eye.length)];
        // Random mouth size
        this.mouth = mouth[rand.nextInt(mouth.length)];
        // Random Id_card
        this.Id_card = rand.nextBoolean();
        // Random Phone_call
        this.Phone_call = rand.nextBoolean();
    }

    private void randomizeAttributes() {
        Random rand = new Random();
        String [] hair = {"Black","Brown","Grey","White"};
        String [] eye = {"Black","Brown","Blue","Green"};
        String [] mouth = {"Big","Slim","Thin"};

        // Random hair colour
        this.hair = hair[rand.nextInt(hair.length)];
        // Random eye colour
        this.eye = eye[rand.nextInt(eye.length)];
        // Random mouth size
        this.mouth = mouth[rand.nextInt(mouth.length)];
        // Random Id_card
        this.Id_card = rand.nextBoolean();
        // Random Phone_call
        this.Phone_call = rand.nextBoolean();
    }
}

