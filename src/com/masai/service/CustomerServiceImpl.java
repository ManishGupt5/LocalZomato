package com.masai.service;

import java.util.HashMap;

import java.util.Scanner;

import com.masai.entities.Customer;
import com.masai.exceptions.*;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void signUp(Scanner sc, HashMap<String, Customer> customers)
			throws DuplicateDataException {

		// Customer customer;// (String name,String password, String address, String
		// email)
		// System.out.println("Enter your name");
		// String name = sc.next();
		// System.out.println("Enter your new Password ");
		// String password = sc.next();
		// System.out.println("Enter address");
		// String address = sc.next();
		// if (customers.containsKey(customer.getEmail())) {
		// throw new DuplicateDataException("Customer already exists , please login");
		// } else {
		// customers.put(customer.getEmail(), customer);
		// }

	}

	@Override
	public boolean login(String email, String password, HashMap<String, Customer> customers)
			throws InvalidCredentialsException {

		if (customers.containsKey(email)) {

			if (customers.get(email).getPassword().equals(password)) {
				return true;
			} else {
				throw new InvalidCredentialsException("Invalid Credentials");
			}

		} else {
			throw new InvalidCredentialsException("you have not sign up yet");
		}

	}

}
