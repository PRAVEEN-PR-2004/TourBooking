package com.example.controller;

import java.util.List;

import com.example.DAO.BookingDAO;
import com.example.model.Booking;

public class BookingController {

    BookingDAO bookDao = new BookingDAO();

    public boolean createBooking(int tourId, int people, int customer_id) {
        return bookDao.createBookingData(tourId, people, customer_id);
    }

    public boolean deleteBooking(int id) {
        return (bookDao.deleteBookingData(id));
    }

    public List<Booking> showMyBookings(int id) {
        return bookDao.getBookingsByCustomerId(id);
    }
}
