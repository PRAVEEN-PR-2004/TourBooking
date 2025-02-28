package com.example.controller;

import com.example.DAO.AdminDAO;
import com.example.model.Admin;

public class AdminController {
    private AdminDAO adminDAO = new AdminDAO();

    public void loginAdmin(String name, String password) {
        Admin admin = adminDAO.validateAdmin(name, password);
        if (admin != null) {
            System.out.println("WELCOME ADMIN " + admin.getAdminName());
        } else {
            System.out.println("Invalid");
        }
    }
}
