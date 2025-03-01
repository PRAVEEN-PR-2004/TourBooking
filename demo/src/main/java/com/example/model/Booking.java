package com.example.model;

public class Booking {
    private int bookingId;
    private String location;
    private int noOfDays;
    private int noOfPersons;
    private int totalPrice;
    private int customerId;

    // Default Constructor

    // Parameterized Constructor
    public Booking(int bookingId, String location, int noOfDays, int noOfPersons, int totalPrice, int customerId) {
        this.bookingId = bookingId;
        this.location = location;
        this.noOfDays = noOfDays;
        this.noOfPersons = noOfPersons;
        this.totalPrice = totalPrice;
        this.customerId = customerId;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public int getNoOfPersons() {
        return noOfPersons;
    }

    public void setNoOfPersons(int noOfPersons) {
        this.noOfPersons = noOfPersons;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", location=" + location + ", noOfDays=" + noOfDays
                + ", noOfPersons=" + noOfPersons + ", totalPrice=" + totalPrice + ", customerId=" + customerId + "]";
    }
}
