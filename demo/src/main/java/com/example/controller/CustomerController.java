package com.example.controller;

import com.example.DAO.CustomerDAO;
import com.example.model.Customer;

public class CustomerController {

    private CustomerDAO customerDAO = new CustomerDAO();

    public boolean loginCustomer(String number, String password) {
        Customer customer = customerDAO.validateCustomer(number, password);
        if (customer != null) {
            return true;
        } else
            return false;
    }

    public void signupCustomer(String name, String number, String password) {
        customerDAO.createCustomer(name, number, password);
    }
}
