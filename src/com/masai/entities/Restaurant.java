package com.masai.entities;

import java.util.HashMap;
import java.util.Map;

public class Restaurant extends User {

    HashMap<Integer, FoodItem> itemList = new HashMap<>();
    String opTime;
    String cTime;

    public Restaurant(String name, String password, String address, String email,
            String opTime, String cTime) {
        super(name, password, address, email);
        this.opTime = opTime;
        this.cTime = cTime;
    }

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
            System.out.println("update food item successfully");
        } else {
            System.out.println("Given Id not found");
        }
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

    public void PrintFoodItems() {
        System.out.println("Food Item List ");
        System.out.println("----------------");
        for (Map.Entry<Integer, FoodItem> i : itemList.entrySet()) {
            System.out.println("Id : " + i.getKey() + " Category : " + i.getValue().catagory + " Name : "
                    + i.getValue().name + " Price : " + i.getValue().price);
            System.out.println("----------------");
        }
    }

}
