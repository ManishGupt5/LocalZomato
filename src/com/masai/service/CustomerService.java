package com.masai.service;

import java.util.HashMap;
import java.util.Scanner;

import com.masai.entities.Customer;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidCredentialsException;

public interface CustomerService {

	public void signUp(Scanner sc, HashMap<String, Customer> customers) throws DuplicateDataException;

	public boolean login(String email, String password, HashMap<String, Customer> customers)
			throws InvalidCredentialsException;

}
