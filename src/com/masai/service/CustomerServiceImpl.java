package com.masai.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.masai.entities.Customer;
import com.masai.exceptions.*;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void signUp(Customer customer, HashMap<String, Customer> customers)
			throws DuplicateDataException {

		if (customers.containsKey(customer.getEmail())) {
			throw new DuplicateDataException("Customer already exists , please login");
		} else {
			customers.put(customer.getEmail(), customer);
		}

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

	@Override
	public List<Customer> viewAllCustomers(HashMap<String, Customer> customers) {
		List<Customer> list = null;
		if (customers != null && customers.size() > 0) {
			Collection<Customer> coll = customers.values();
			list = new ArrayList<>(coll);
		} else {
			System.out.println("Customer list is empty");
		}
		return list;
	}

}
