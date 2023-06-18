package com.masai.service;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale.Category;

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
			throws InvalidCredentialsException, InputMismatchException {
		try {
			System.out.println("Enter the Restaurant name");
			this.name = sc.next();
			System.out.println("Enter the registered email");
			this.email = sc.next();
			System.out.println("Enter the password");
			this.password = sc.next();
			System.out.println("Enter the registered address");
			this.password = sc.next();
			boolean checking = false;
			if (Restaurants.get(email) != null && Restaurants.get(email).getPassword() == password) {
				while (checking != true) {
					if (Restaurants.get(email).getAddress() == address && Restaurants.get(email).getName() == name) {
						checking = true;
						break;
					} else {
						System.out.println("Enter the right Restaurant name");
						this.name = sc.next();
						System.out.println("Enter the registered address");
						this.password = sc.next();
					}
				}
				System.out.println("Login successful");

			} else {
				throw new InvalidCredentialsException("Invalid username/password");
			}
		} catch (InputMismatchException e) {
			throw new InputMismatchException("Invalid input type");
		} catch (Exception e) {
			e.getCause();
		}

	}

	@Override
	public void addFoodItem(Scanner sc, HashMap<User, FoodItem> foodItems) throws DuplicateDataException {
		System.out.println("Enter unique id ");
		// new FoodItem(0, Category, name, 0)
	}

	@Override
	public void deleteFoodItem(Scanner sc, HashMap<User, FoodItem> foodItems) throws FoodItemException {
		// TODO Auto-generated method stub

	}

	@Override
	public void printAllFoodItems(Scanner sc, HashMap<User, FoodItem> foodItems) throws FoodItemException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFoodItem(Scanner sc, HashMap<User, FoodItem> foodItems) throws FoodItemException {
		// TODO Auto-generated method stub

	}

}
