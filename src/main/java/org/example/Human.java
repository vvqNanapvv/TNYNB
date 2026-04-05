package org.example;

public class Human {
    private String name;
    private String mouth;
    private String eye;
    private String hair;
    private String Id_card;
    private String Phone_call;
    private String Identity;

    Human(String name,String Identity){
        this.name = name;
        this.Identity = Identity;
    }
    Human(String name,String Identity, String mouth, String eye, String hair, String Id_card, String Phone_call){
        this.name = name;
        this.Identity = Identity;
        this.mouth = mouth;
        this.eye = eye;
        this.hair = hair;
        this.Id_card = Id_card;
        this.Phone_call = Phone_call;
    }

    public String getName() {
        return name;
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

    public String getId_card() {
        return Id_card;
    }
    public void setId_card(String id_card) {
        Id_card = id_card;
    }

    public String getPhone_call() {
        return Phone_call;
    }
    public void setPhone_call(String phone_call) {
        Phone_call = phone_call;
    }

    public String getIdentity() {
        return Identity;
    }
}
