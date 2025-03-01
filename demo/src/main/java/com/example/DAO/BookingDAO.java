package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.DBConnection;
import com.example.model.Booking;

public class BookingDAO {

    public boolean createBookingData(int tourid, int persons, int customer_id) {
        String query = "SELECT no_of_days, tour_location, tour_price FROM tours WHERE tour_id = ?";
        String insertQuery = "INSERT INTO bookings (location, no_of_days, no_of_persons, tot_price, customer_id) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement psmt = conn.prepareStatement(query)) {

            // Fetch tour details
            psmt.setInt(1, tourid);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                int noOfDays = rs.getInt("no_of_days");
                String location = rs.getString("tour_location");
                int tourPrice = rs.getInt("tour_price");

                // Calculate total price
                int totalPrice = tourPrice * persons;

                // Insert booking data
                try (PreparedStatement psmt2 = conn.prepareStatement(insertQuery)) {
                    psmt2.setString(1, location);
                    psmt2.setInt(2, noOfDays);
                    psmt2.setInt(3, persons);
                    psmt2.setInt(4, totalPrice);
                    psmt2.setInt(5, customer_id);

                    int rowsInserted = psmt2.executeUpdate();
                    if (rowsInserted > 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                System.out.println("Tour not found with ID: " + tourid);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print error details
            return false;
        }
    }

    public boolean deleteBookingData(int id) {
        String query = "DELETE FROM bookings WHERE booking_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setInt(1, id);
            int rowDeleted = psmt.executeUpdate();
            if (rowDeleted > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            return false;
        }

    }

    public List<Booking> getBookingsByCustomerId(int customerId) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE customer_id = ?";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement psmt = conn.prepareStatement(query)) {

            psmt.setInt(1, customerId);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                int bookid = rs.getInt("booking_id");
                String location = rs.getString("location");
                int no_of_days = rs.getInt("no_of_days");
                int no_of_persons = rs.getInt("no_of_persons");
                int tot_price = rs.getInt("tot_price");
                // int customer_id = rs.getInt("customer_id");

                Booking booking = new Booking(bookid, location, no_of_days, no_of_persons, tot_price, customerId);
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}
