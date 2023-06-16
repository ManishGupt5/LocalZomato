package com.masai.entities;

import java.time.LocalTime;

import java.util.HashMap;
import java.util.Map;

public class Restaurant extends User {
    HashMap<Integer, FoodItem> itemList = new HashMap<>();
    LocalTime opTime;
    LocalTime cTime;

    public void addFoodItem(int id, String catagory, String name, int price) {

        if (itemList.containsKey(id) == false) {
            itemList.put(id, new FoodItem(id, catagory, name, price));

        } else {
            System.out.println("Id already present");
        }
    }

    public void removeFoodItem(int id) {
        if (itemList.containsKey(id)) {
            itemList.remove(id);
            System.out.println("Item remove successfuly");
        } else {
            System.out.println("Please provide right id, item not found");
        }
    }

    public void updateFoodItem(int id, String catagory, String name, int price) {
        if (itemList.containsKey(id)) {
            itemList.replace(id, new FoodItem(id, catagory, name, price));
        } else {
            System.out.println("Given Id not found");
        }
    }

    public void updateRestaurantEmail(String email) {
        this.setEmail(email);
    }

    public void updateRestaurantName(String name) {
        this.setName(name);
    }

    public void updateRestaurantPassword(String password) {
        setPassword(password);
    }

    public void updateRestaurantOpenTime(LocalTime opTime) {
        this.opTime = opTime;
    }

    public void updateRestaurantClosingTime(LocalTime cTime) {
        this.cTime = cTime;
    }

    public void PrintFoodItems() {
        for (Map.Entry<Integer, FoodItem> i : itemList.entrySet()) {
            System.out.println("Id : " + i.getKey() + " Category : " + i.getValue().catagory + " Name : "
                    + i.getValue().name + " Price : " + i.getValue().price);
        }
    }

}
