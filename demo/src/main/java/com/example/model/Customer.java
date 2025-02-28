package com.example.model;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerNumber;
    private String customerPassword;

    // Constructor
    public Customer(int customerId, String customerName, String customerNumber, String customerPassword) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerPassword = customerPassword;
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    // // Setters (optional, if modification is needed)
    // public void setCustomerName(String customerName) {
    // this.customerName = customerName;
    // }

    // public void setCustomerNumber(String customerNumber) {
    // this.customerNumber = customerNumber;
    // }

    // public void setCustomerPassword(String customerPassword) {
    // this.customerPassword = customerPassword;
    // }
}
