package com.example.view;

import java.util.Scanner;

import com.example.controller.AdminController;

public class AdminView {

    public void adminInterface() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- WELCOME ----------");
        System.out.println("Login To Continue");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        AdminController adminlogin = new AdminController();
        adminlogin.loginAdmin(name, password);

    }
}
