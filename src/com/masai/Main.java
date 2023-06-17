package com.masai;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

import com.masai.entities.Customer;
import com.masai.entities.Restaurant;
import com.masai.exceptions.DuplicateDataException;
import com.masai.utility.FileExists;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {

        HashMap<String, Restaurant> restaurants = (HashMap<String, Restaurant>) FileExists.RestaurantFile();
        HashMap<String, Customer> customers = FileExists.customerFile();

        try {
            Scanner sc = new Scanner(System.in);
            int preference = 0;
            do {
                System.out.println("=================================================");
                System.out.println("  Welcome to LocalZomaato Console Application!");
                System.out.println("=================================================");
                System.out.println("Please select an option to continue:");
                System.out.println("Who are you !");
                System.out.println("1. Administrator");
                System.out.println("2. Customer");
                System.out.println("3. Restaurant Owner");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                preference = sc.nextInt();

                switch (preference) {
                    case 1:
                        adminFunctionality(sc, restaurants);
                        break;
                    case 2:
                        customerFunctionality(sc, customers);
                        break;
                    case 3:
                        restaurantFunctionality(sc, restaurants);
                        break;
                    case 4:
                        System.out.println("successfully existed from the system");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid Selection");
                }

            } while (preference != 4);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                ObjectOutputStream poos = new ObjectOutputStream(new FileOutputStream("Restaurant.ser"));
                poos.writeObject(restaurants);
                poos.close();
                ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("Customer.ser"));
                coos.writeObject(customers);
                coos.close();
                // update data
            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
        }
    }

    private static void restaurantFunctionality(Scanner sc, Map<String, Restaurant> restaurants) {

    }

    private static void customerFunctionality(Scanner sc, Map<String, Customer> customers) {
    }

    private static void adminFunctionality(Scanner sc, Map<String, Restaurant> restaurants) {
    }

    public static void customerSignup(Scanner sc, Map<String, Customer> customers) throws DuplicateDataException {
        System.out.println("Enter the following details to Signup");

        try {
            System.out.println("Enter the unique username");

        } catch (Exception e) {

        }
        String username = sc.next();
        System.out.println("Enter the name");
        String name = sc.next();
        System.out.println("Enter the password");
        String pass = sc.next();
        System.out.println("enter the address");
        String address = sc.next();
        System.out.println("Enter the email id");
        String email = sc.next();

        Customer cus = new Customer(name, username, pass, address, email);

        // CustomerService cusService = new CustomerServiceImpl();
        // cusService.signUp(cus, customers);
        System.out.println("customer has Succefully sign up");

    }
}