package com.example.DAO;

import com.example.model.Customer;
import com.example.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    public Customer validateCustomer(String customerName, String customerPassword) {
        Customer customer = null;
        String query = "SELECT * FROM customers WHERE customer_name = ? AND customer_password = ?";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, customerName);
            pstmt.setString(2, customerPassword);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer(
                            rs.getInt("customer_id"),
                            rs.getString("customer_name"),
                            rs.getString("customer_number"),
                            rs.getString("customer_password"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void createCustomer(String name, String number, String password) {
        String query = "INSERT INTO customers (customer_name, customer_number, customer_password) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, number);
            pstmt.setString(3, password);

            int rowsInserted = pstmt.executeUpdate(); // ✅ Use executeUpdate() for INSERT
            if (rowsInserted > 0) {
                System.out.println("Customer created successfully!");

            }
        } catch (SQLException e) {
            System.out.println("Error inserting customer: " + e.getMessage()); // ✅ Print the actual error
        }
    }

}
