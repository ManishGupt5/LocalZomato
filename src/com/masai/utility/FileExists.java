package com.masai.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.masai.entities.Customer;
import com.masai.entities.FoodItem;
import com.masai.entities.Restaurant;
import com.masai.entities.User;

public class FileExists {
    public static HashMap<String, Restaurant> RestaurantFile() {
        File f = new File("Restaurants.ser");
        if (!f.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (HashMap<String, Restaurant>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static HashMap<String, Customer> customerFile() {
        File f = new File("Customers.ser");
        if (!f.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (HashMap<String, Customer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static HashMap<User, ArrayList<FoodItem>> restaurantFoodItem() {
        File f = new File("FoodItems.ser");
        if (!f.exists()) {
            return new HashMap<User, ArrayList<FoodItem>>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (HashMap<User, ArrayList<FoodItem>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
