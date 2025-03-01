package com.example.controller;

import com.example.DAO.TourDAO;
import com.example.model.Tour;
import java.util.List;

public class TourController {

    private TourDAO tourDAO = new TourDAO();

    public boolean addTour(int days, String location, int price) {
        return tourDAO.createTour(days, location, price);
    }

    public boolean deleteTour(int id) {
        return tourDAO.deleteTourData(id);
    }

    public boolean updateTour(int id, int days, String location, int price) {
        return tourDAO.updateTourData(id, days, location, price);
    }

    // **NEW METHOD TO GET TOURS FROM DAO**
    public List<Tour> getTours() {
        return tourDAO.getAllTours();
    }
}
