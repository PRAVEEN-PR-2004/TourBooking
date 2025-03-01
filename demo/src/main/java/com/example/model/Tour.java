package com.example.model;

public class Tour {
    private int tourId;
    private int Days;
    private String Location;
    private int price;

    public Tour(int tourId, int Days, String Location, int price) {
        this.tourId = tourId;
        this.Days = Days;
        this.Location = Location;
        this.price = price;
    }

    public int getTourId() {
        return tourId;
    }

    public int getDays() {
        return Days;
    }

    public String getLocation() {
        return Location;
    }

    public int getPrice() {
        return price;
    }
}
