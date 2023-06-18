package com.masai.service;

import java.util.List;
import java.util.HashMap;

import com.masai.entities.Customer;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidCredentialsException;

public interface CustomerService {

	public void signUp(Customer customer, HashMap<String, Customer> customers) throws DuplicateDataException;

	public boolean login(String email, String password, HashMap<String, Customer> customers)
			throws InvalidCredentialsException;

	public List<Customer> viewAllCustomers(HashMap<String, Customer> customers);

}
