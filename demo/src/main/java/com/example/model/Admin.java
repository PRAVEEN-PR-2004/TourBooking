package com.example.model;

public class Admin {
    private int adminId;
    private String adminName;
    private String adminPassword;

    public Admin(int adminId, String adminName, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public int getAdminId() {
        return adminId;
    }
}
