package com.masai.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.masai.entities.FoodItem;

import com.masai.entities.Restaurant;
import com.masai.entities.User;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.FoodItemException;
import com.masai.exceptions.InvalidCredentialsException;

public class RestaurantServicesImpl implements RestaurantService {
	private String name;
	private String password;
	private String address;
	private String email;

	public String getname() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public void login(Scanner sc, HashMap<String, Restaurant> Restaurants)
			throws InvalidCredentialsException {

		System.out.println("Enter the Restaurant name");
		this.name = sc.next();
		System.out.println("Enter the registered email");
		this.email = sc.next();
		System.out.println("Enter the password");
		this.password = sc.next();
		System.out.println("Enter the registered address");
		this.password = sc.next();
		Restaurant restaurant = Restaurants.get(email);
		System.out.println(restaurant);
		if (restaurant != null && restaurant.getPassword().equals(password)) {
			System.out.println("Login successful");
		} else {
			throw new InvalidCredentialsException("Invalid username/password");
		}

	}

	@Override
	public void addFoodItem(Scanner sc, HashMap<User, ArrayList<FoodItem>> foodItems) throws DuplicateDataException {
		// login
		User temp = new User(name, password, address, email);
		ArrayList<FoodItem> myFoodItems = foodItems.get(temp);
		int id = 0;
		String category = "";
		String itemName = "";
		int price = 0;

		System.out.println("Enter unique id ");
		System.out.println("[ Note: if you give any item id than that item will be replace with new foodItem");
		try {
			System.out.println("first view the all fooditem id ]");
			id = sc.nextInt();
			System.out.println("Enter category name");
			category = sc.next();
			System.out.println("Enter the Item name");
			itemName = sc.next();
			System.out.println("Enter price for this new item");
			price = sc.nextInt();
			if (myFoodItems.contains(new FoodItem(id, category, itemName, price))) {
				throw new DuplicateDataException("Id already present in Fooditem");
			} else {
				myFoodItems.add(new FoodItem(id, category, itemName, price));
				System.out.println("Added successfuly");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid number.");

		} catch (IllegalArgumentException e) {
			System.out.println("Invalid selection. Please enter a valid choice.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteFoodItem(Scanner sc, HashMap<User, ArrayList<FoodItem>> foodItems) throws FoodItemException {
		User temp = new User(name, password, address, email);
		ArrayList<FoodItem> myFoodItems = foodItems.get(temp);
		int id = 0;
		String category = "";
		String itemName = "";
		int price = 0;
		try {
			System.out.println("Enter unique id ");
			id = sc.nextInt();
			System.out.println("Enter category name");
			category = sc.next();
			System.out.println("Enter the Item name");
			itemName = sc.next();
			System.out.println("Enter price of item");
			price = sc.nextInt();
			if (myFoodItems.contains(new FoodItem(id, category, itemName, price))) {
				myFoodItems.remove(new FoodItem(id, category, itemName, price));
				System.out.println("Successfully removed");
			} else {
				System.out.println("Data not found");
			}
		} catch (InputMismatchException e) {
			e.getCause();

		} catch (IllegalArgumentException e) {
			e.getCause();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void printAllFoodItems(Scanner sc, HashMap<User, ArrayList<FoodItem>> foodItems) throws FoodItemException {
		User temp = new User(name, password, address, email);
		ArrayList<FoodItem> myFoodItems = foodItems.get(temp);
		System.out.println("FoodItem List");
		System.out.println("Total Items :" + myFoodItems.size());
		int x = 1;
		if (myFoodItems.size() > 0) {
			for (FoodItem i : myFoodItems) {
				System.out.println(x++ + " :");
				System.out.println(i.id + " " + i.catagory + " " + i.name + " " + i.price);
			}
		}

	}

	@Override
	public void updateFoodItem(Scanner sc, HashMap<User, ArrayList<FoodItem>> foodItems) throws FoodItemException {
		// TODO Auto-generated method stub

	}

}
