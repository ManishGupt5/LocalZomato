package com.masai.service;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.masai.entities.FoodItem;
import com.masai.entities.Restaurant;
import com.masai.entities.User;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.FoodItemException;
import com.masai.exceptions.InvalidCredentialsException;

public interface RestaurantService {

	public void login(Scanner sc, HashMap<String, Restaurant> Restaurants)
			throws InputMismatchException, InvalidCredentialsException;

	public void printAllFoodItems(Scanner sc, HashMap<User, FoodItem> foodItems) throws FoodItemException;

	public void addFoodItem(Scanner sc, HashMap<User, FoodItem> foodItems) throws DuplicateDataException;

	public void deleteFoodItem(Scanner sc, HashMap<User, FoodItem> foodItems) throws FoodItemException;

	public void updateFoodItem(Scanner sc, HashMap<User, FoodItem> foodItems)
			throws FoodItemException;

}
