package com.masai.service;

import java.util.Collection;
import java.util.HashMap;

import java.util.Scanner;
import com.masai.entities.FoodItem;

import com.masai.entities.Restaurant;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.FoodItemException;
import com.masai.exceptions.InvalidCredentialsException;

public class RestaurantServicesImpl implements RestaurantService {

	@Override
	public boolean login(String email, String password, HashMap<String, Restaurant> Restaurants,
			Restaurant myRestaurant)
			throws InvalidCredentialsException {

		return true;

	}

	@Override
	public void addFoodItem(Scanner sc, Restaurant myRestaurant) throws DuplicateDataException {

	}

	@Override
	public void viewAllFoodItems(Scanner sc, Restaurant myRestaurant) throws FoodItemException {

	}

	@Override
	public void deleteFoodItem(Scanner sc, Restaurant myRestaurant) throws FoodItemException {

	}

	@Override
	public void updateFoodItem(Scanner sc, Restaurant myRestaurant)
			throws FoodItemException {

	}

}
