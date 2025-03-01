package com.example.controller;

import com.example.DAO.AdminDAO;
import com.example.model.Admin;

public class AdminController {
    private AdminDAO adminDAO = new AdminDAO();

    public Admin loginAdmin(String name, String password) {
        Admin admin = adminDAO.validateAdmin(name, password);
        return admin;
    }
}
