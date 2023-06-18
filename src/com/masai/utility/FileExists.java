package com.masai.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public static HashMap<User, FoodItem> restaurantFoodItem() {
        File f = new File("FoodItems.ser");
        if (!f.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (HashMap<User, FoodItem>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}

// ---------------------------------------------------------------------------------
// public class FileExists {
// @SuppressWarnings("unchecked")
// public static HashMap<String, Restaurant> RestaurantFile() {

// HashMap<String, Restaurant> pFile = null;

// File f = new File("Restaurants.ser");
// boolean flag = false;
// try {
// if (!f.exists()) {
// f.createNewFile();
// flag = true;
// }

// if (flag) {
// pFile = new HashMap<>();
// ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f,
// true));
// oos.writeObject(pFile);
// oos.close();
// return pFile;

// } else {

// ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

// pFile = (HashMap<String, Restaurant>) ois.readObject();
// ois.close();
// return pFile;
// }

// } catch (Exception e) {
// System.out.println(e.getMessage());
// }
// return pFile;
// }

// @SuppressWarnings("unchecked")
// public static HashMap<String, Customer> customerFile() {

// HashMap<String, Customer> cFile = null;// String for email

// File f = new File("Customers.ser");
// boolean flag = false;
// try {
// if (!f.exists()) {
// f.createNewFile();
// flag = true;
// }
// if (flag) {

// cFile = new HashMap<>();
// ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f,
// true));
// oos.writeObject(cFile);
// oos.close();
// return cFile;

// } else {

// ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
// cFile = (HashMap<String, Customer>) ois.readObject();
// ois.close();
// return cFile;

// }

// } catch (Exception e) {
// System.out.println(e.getMessage());
// }
// return cFile;

// }

// @SuppressWarnings("unchecked")
// public static HashMap<User, FoodItem> restaurantFoodItem() {

// HashMap<User, FoodItem> iFile = null;

// File f = new File("FoodItems.ser");
// boolean flag = false;
// try {
// if (!f.exists()) {
// f.createNewFile();
// flag = true;
// }

// if (flag) {

// iFile = new HashMap<>();
// ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f,
// true));
// oos.writeObject(iFile);
// oos.close();
// return iFile;

// } else {
// ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
// iFile = (HashMap<User, FoodItem>) ois.readObject();
// ois.close();
// return iFile;
// }

// } catch (Exception e) {
// System.out.println(e.getMessage());
// }
// return iFile;
// }

// }
