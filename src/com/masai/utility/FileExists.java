package com.masai.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.masai.entities.Customer;
import com.masai.entities.Restaurant;

public class FileExists {
    @SuppressWarnings("unchecked")
    public static Map<String, Restaurant> RestaurantFile() {

        HashMap<String, Restaurant> pFile = null;

        File f = new File("Restaurants.ser");
        boolean flag = false;
        try {
            if (!f.exists()) {
                f.createNewFile();
                flag = true;
            }

            if (flag) {

                pFile = new HashMap<>();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(pFile);
                oos.close();
                return pFile;

            } else {

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

                pFile = (HashMap<String, Restaurant>) ois.readObject();
                ois.close();
                return pFile;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pFile;
    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, Customer> customerFile() {

        HashMap<String, Customer> cFile = null;// String for email

        File f = new File("Customers.ser");
        boolean flag = false;
        try {
            if (!f.exists()) {
                f.createNewFile();
                flag = true;
            }
            if (flag) {

                cFile = new HashMap<>();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(cFile);
                oos.close();
                return cFile;

            } else {

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                cFile = (HashMap<String, Customer>) ois.readObject();
                ois.close();
                return cFile;

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cFile;

    }

}
