package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.DBConnection;
import com.example.model.Tour;

public class TourDAO {

    public boolean createTour(int days, String tourLocation, int tourPrice) {
        String query = "INSERT INTO tours (no_of_days, tour_location, tour_price) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, days);
            pstmt.setString(2, tourLocation);
            pstmt.setInt(3, tourPrice);
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteTourData(int tourid) {
        String query = "DELETE FROM tours WHERE tour_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement psmt = conn.prepareStatement(query);) {
            psmt.setInt(1, tourid);
            int rowDeleted = psmt.executeUpdate();
            return rowDeleted > 0;
        } catch (SQLException e) {
            return false;
        }

    }

    public boolean updateTourData(int id, int Days, String tourLocation, int price) {
        String query = "UPDATE tours SET no_of_days = ?, tour_location = ?, tour_price = ? WHERE tour_id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, Days);
            pstmt.setString(2, tourLocation);
            pstmt.setInt(3, price);
            pstmt.setInt(4, id);
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error updating tour: " + e.getMessage());
            return false;
        }
    }

    // **NEW METHOD TO GET ALL TOURS**
    public List<Tour> getAllTours() {
        List<Tour> tours = new ArrayList<>();
        String query = "SELECT tour_id, no_of_days, tour_location, tour_price FROM tours";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("tour_id");
                int days = rs.getInt("no_of_days");
                String location = rs.getString("tour_location");
                int price = rs.getInt("tour_price");

                tours.add(new Tour(id, days, location, price));
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return tours;
    }
}
