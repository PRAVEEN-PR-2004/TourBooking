package com.example.controller;

import com.example.DAO.CustomerDAO;
import com.example.model.Customer;

public class CustomerController {

    private CustomerDAO customerDAO = new CustomerDAO();

    public void loginCustomer(String number, String password) {
        Customer customer = customerDAO.validateCustomer(number, password);
        if (customer != null) {
            System.out.println("Login successful! Welcome, " + customer.getCustomerName());
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    public void signupCustomer(String name, String number, String password) {
        customerDAO.createCustomer(name, number, password);
    }
}
