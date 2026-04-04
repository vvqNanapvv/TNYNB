package org.example;

public class Human {
    private String name;
    private String mouth;
    private String eye;
    private String hair;
    private Boolean Id_card;
    private Boolean Phone_call;
    private Boolean Identity;

    Human(String name,Boolean Identity){
        this.name = name;
        this.Identity = Identity;
    }

    public void setHuman(Human human){}

    Human(String name,Boolean Identity, String mouth, String eye, String hair, Boolean Id_card, Boolean Phone_call){
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

    public Boolean getId_card() {
        return Id_card;
    }
    public void setId_card(Boolean id_card) {
        Id_card = id_card;
    }

    public Boolean getPhone_call() {
        return Phone_call;
    }
    public void setPhone_call(Boolean phone_call) {
        Phone_call = phone_call;
    }

    public Boolean getIdentity() {
        return Identity;
    }
}
