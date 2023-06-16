package com.masai.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.LinkedHashMap;

import java.util.Map;

import com.masai.entities.Customer;
import com.masai.entities.Restaurant;

public class FileExists {

    public static Map<Integer, Restaurant> RestaurantFile() {

        Map<Integer, Restaurant> pFile = null;

        File f = new File("Restaurant.ser");
        boolean flag = false;
        try {
            if (!f.exists()) {
                f.createNewFile();
                flag = true;
            }

            if (flag) {

                pFile = new LinkedHashMap<>();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(pFile);
                return pFile;

            } else {

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                pFile = (Map<Integer, Restaurant>) ois.readObject();
                return pFile;

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pFile;
    }

    public static Map<String, Customer> customerFile() {

        Map<String, Customer> cFile = null;

        File f = new File("Customer.ser");
        boolean flag = false;
        try {
            if (!f.exists()) {
                f.createNewFile();
                flag = true;
            }

            if (flag) {

                cFile = new LinkedHashMap<>();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(cFile);
                return cFile;

            } else {

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                cFile = (Map<String, Customer>) ois.readObject();

                return cFile;

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return cFile;

    }

}
