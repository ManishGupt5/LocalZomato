package com.masai;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.util.Map;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.entities.Customer;
import com.masai.entities.FoodItem;
import com.masai.entities.Restaurant;
import com.masai.entities.User;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidCredentialsException;
import com.masai.service.CustomerService;
import com.masai.service.CustomerServiceImpl;
import com.masai.service.RestaurantService;
import com.masai.service.RestaurantServicesImpl;
import com.masai.utility.Admin;
import com.masai.utility.FileExists;

public class Main {

    public static void main(String[] args) throws IllegalArgumentException {

        HashMap<String, Restaurant> restaurants = (HashMap<String, Restaurant>) FileExists.RestaurantFile();
        HashMap<String, Customer> customers = FileExists.customerFile();
        HashMap<User, FoodItem> foodItems = FileExists.restaurantFoodItem();

        try {
            Scanner sc = new Scanner(System.in);
            int preference = 0;
            System.out.println(" ------------------------------------------------");
            System.out.println("  Welcome to LocalZomaato Console Application!  ");
            System.out.println(" ------------------------------------------------");
            do {
                System.out.println("Please select an option to continue:");
                System.out.println("Who are you !");
                System.out.println("1. Administrator");
                System.out.println("2. Customer");
                System.out.println("3. Restaurant Owner");
                System.out.println("4. Exit");
                System.out.println();
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
                        restaurantFunctionality(sc, restaurants, foodItems);
                        break;
                    case 4:
                        System.out.println("successfully existed from the system");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid Selection");
                }

            } while (preference != 4);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid selection. Please enter a valid choice.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ObjectOutputStream poos = new ObjectOutputStream(new FileOutputStream("Restaurants.ser"));
                poos.writeObject(restaurants);
                poos.close();
                ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("Customers.ser"));
                coos.writeObject(customers);
                coos.close();
                ObjectOutputStream foos = new ObjectOutputStream(new FileOutputStream("FoodItems.ser"));
                foos.writeObject(foodItems);
                foos.close();

            } catch (IOException e) {
                System.out.println("Error occurred while writing objects to file: " + e.getMessage());

                System.out.println(e.getMessage());
            }
        }
    }

    private static void restaurantFunctionality(Scanner sc, Map<String, Restaurant> restaurants,
            HashMap<User, FoodItem> foodItems)
            throws InputMismatchException, IllegalArgumentException, InvalidCredentialsException {

        RestaurantService rService = new RestaurantServicesImpl();
        rService.login(sc, (HashMap<String, Restaurant>) restaurants);
        try {

            int restaurantPreference = 0;
            do {
                System.out.println("Please select an option to continue:");
                System.out.println("1. Add a new Food Item");
                System.out.println("2. Delete a Food Item");
                System.out.println("3. Print all Food Items");
                System.out.println("4. Update a Food Item");
                System.out.println("5. Logout");

                System.out.println();
                System.out.print("Enter your choice: ");

                restaurantPreference = sc.nextInt();

                switch (restaurantPreference) {
                    case 1:
                        rService.addFoodItem(sc, foodItems);
                        break;
                    case 2:
                        rService.deleteFoodItem(sc, foodItems);
                        break;
                    case 3:
                        rService.printAllFoodItems(sc, foodItems);
                        break;
                    case 4:
                        rService.updateFoodItem(sc, foodItems);
                        break;
                    case 5:
                        System.out.println("Logout successfully");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid Selection");
                }

            } while (restaurantPreference != 5);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid selection. Please enter a valid choice.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void customerFunctionality(Scanner sc, Map<String, Customer> customers) {
    }

    private static void adminFunctionality(Scanner sc, Map<String, Restaurant> restaurants)
            throws InputMismatchException, IllegalArgumentException, InvalidCredentialsException {
        adminLogin(sc);
        try {
            int adminPreference = 0;
            System.out.println(" ---------------------------");
            do {
                System.out.println("Enter an option to continue:");
                System.out.println("1. Add a Restaurant");
                System.out.println("2. Delete a Restaurant");
                System.out.println("3. Print All Restaurants");
                System.out.println("4. Logout");
                System.out.println();
                System.out.print("Enter your choice: ");

                adminPreference = sc.nextInt();

                switch (adminPreference) {
                    case 1:
                        addRestaurant(sc, restaurants);
                        break;
                    case 2:
                        deleteRestaurant(sc, restaurants);
                        break;
                    case 3:
                        printRestaurant(restaurants);
                        break;
                    case 4:
                        System.out.println("Logout successfully");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid Selection");
                }
            } while (adminPreference != 4);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid selection. Please enter a valid choice.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void printRestaurant(Map<String, Restaurant> restaurants) {
        System.out.println("______________________________");
        System.out.println("List of Restaurants:");
        System.out.println("Total Restaurant : " + restaurants.size());
        int x = 1;
        for (Restaurant restaurant : restaurants.values()) {
            System.out.println(x++ + " :");
            System.out.println("Name: " + restaurant.getName());
            System.out.println("Address: " + restaurant.getAddress());
            System.out.println("Username/Email : " + restaurant.getEmail());
            System.out.println("Password : " + restaurant.getPassword());

        }
        System.out.println("______________________________");
    }

    public static void deleteRestaurant(Scanner sc, Map<String, Restaurant> restaurants) {
        System.out.println("Enter Username/Email of Restaurant");
        String username = sc.next();
        restaurants.remove(username);
        System.out.println("Restaurant successfuly deleted");
    }

    public static void adminLogin(Scanner sc) throws InvalidCredentialsException {

        System.out.println("Enter the username");
        String userName = sc.next();
        System.out.println("Enter the password");
        String password = sc.next();
        if (userName.equals(Admin.username) && password.equals(Admin.password)) {
            System.out.println("Welcome back , " + Admin.username);
        } else {
            throw new InvalidCredentialsException("Invalid Admin Credentials");
        }
    }

    public static void addRestaurant(Scanner sc, Map<String, Restaurant> restaurants) {

        System.out.println("Add a New Restaurant");
        System.out.print("Enter the restaurant name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Enter the restaurant address: ");
        String address = sc.next();
        System.out.println("Enter the restaurant password: ");
        String password = sc.next();
        System.out.println("Enter the restaurant Email: ");
        String email = sc.next();
        System.out.println("Enter the restaurant opening time: ");
        String opTime = sc.next();
        System.out.println("Enter the restaurant closing time: ");
        String cTime = sc.next();

        Restaurant newRestaurant = new Restaurant(name, password, address, email, opTime, cTime);

        restaurants.put(newRestaurant.getEmail(), newRestaurant);

        System.out.println("Restaurant added successfully!");

    }

}