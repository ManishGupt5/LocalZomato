package com.masai.service;

import java.util.HashMap;
import java.util.Scanner;

import com.masai.entities.Restaurant;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.FoodItemException;
import com.masai.exceptions.InvalidCredentialsException;

public interface RestaurantService {

	public boolean login(String email, String password, HashMap<String, Restaurant> Restaurants,
			Restaurant myRestaurant)
			throws InvalidCredentialsException;

	public void addFoodItem(Scanner sc, Restaurant myRestaurant) throws DuplicateDataException;

	public void viewAllFoodItems(Scanner sc, Restaurant myRestaurant) throws FoodItemException;

	public void deleteFoodItem(Scanner sc, Restaurant myRestaurant) throws FoodItemException;

	public void updateFoodItem(Scanner sc, Restaurant myRestaurant)
			throws FoodItemException;

}
