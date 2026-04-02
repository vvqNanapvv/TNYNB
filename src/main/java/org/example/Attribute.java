package org.example;

public class Attribute {
    private String name;
    private String mouth;
    private String eye;
    private String hair;
    private boolean Id_card;
    private boolean Phone_call;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public boolean isId_card() {
        return Id_card;
    }

    public void setId_card(boolean id_card) {
        Id_card = id_card;
    }

    public boolean isPhone_call() {
        return Phone_call;
    }

    public void setPhone_call(boolean phone_call) {
        Phone_call = phone_call;
    }
}
