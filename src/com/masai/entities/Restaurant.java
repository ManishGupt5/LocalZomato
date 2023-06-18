package com.masai.entities;

public class Restaurant extends User {
    String opTime;
    String cTime;

    public Restaurant(String name, String password, String address, String email,
            String opTime, String cTime) {
        super(name, password, address, email);
        this.opTime = opTime;
        this.cTime = cTime;
    }

    public void updateRestaurantEmail(String email) {
        setEmail(email);
    }

    public void updateRestaurantName(String name) {
        this.setName(name);
    }

    public void updateRestaurantPassword(String password) {
        setPassword(password);
    }

    public void updateRestaurantOpenTime(String opTime) {
        this.opTime = opTime;
    }

    public void updateRestaurantClosingTime(String cTime) {
        this.cTime = cTime;
    }

}
