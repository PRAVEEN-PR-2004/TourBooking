package com.example.DAO;

import com.example.model.Admin;
import com.example.DBConnection;
import java.sql.*;

public class AdminDAO {
    public Admin validateAdmin(String name, String password) {
        Admin admin = null;
        String query = "SELECT * FROM admin WHERE admin_name = ? AND admin_password = ?";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    admin = new Admin(
                            rs.getInt("admin_id"),
                            rs.getString("admin_name"),
                            rs.getString("admin_password"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
