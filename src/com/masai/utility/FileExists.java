
package com.masai.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.masai.entities.Customer;
import com.masai.entities.FoodItem;
import com.masai.entities.Restaurant;
import com.masai.entities.User;

public class FileExists {
    @SuppressWarnings("unchecked")
    public static HashMap<String, Restaurant> RestaurantFile() {
        HashMap<String, Restaurant> rFile = null;

        File f = new File("Restaurants.ser");
        boolean flag = false;
        try {
            if (!f.exists()) {
                f.createNewFile();
                flag = true;
            }

            if (flag) {
                rFile = new HashMap<>();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f, true));
                oos.writeObject(rFile);
                oos.close();
            } else {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                rFile = (HashMap<String, Restaurant>) ois.readObject();
                ois.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return rFile != null ? rFile : new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, Customer> customerFile() {
        HashMap<String, Customer> cFile = null;

        File f = new File("Customers.ser");
        boolean flag = false;
        try {
            if (!f.exists()) {
                f.createNewFile();
                flag = true;
            }

            if (flag) {
                cFile = new HashMap<>();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f, true));
                oos.writeObject(cFile);
                oos.close();
            } else {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                cFile = (HashMap<String, Customer>) ois.readObject();
                ois.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return cFile != null ? cFile : new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    public static HashMap<User, ArrayList<FoodItem>> restaurantFoodItem() {
        HashMap<User, ArrayList<FoodItem>> iFile = null;

        File f = new File("FoodItems.ser");
        boolean flag = false;
        try {
            if (!f.exists()) {
                f.createNewFile();
                flag = true;
            }

            if (flag) {
                iFile = new HashMap<>();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f, true));
                oos.writeObject(iFile);
                oos.close();
            } else {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                iFile = (HashMap<User, ArrayList<FoodItem>>) ois.readObject();
                ois.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return iFile != null ? iFile : new HashMap<>();
    }
}
