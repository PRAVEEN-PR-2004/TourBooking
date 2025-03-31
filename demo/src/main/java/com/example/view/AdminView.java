package com.example.view;

import java.util.List;
import java.util.Scanner;
import com.example.controller.AdminController;
import com.example.controller.TourController;
import com.example.model.Admin;
import com.example.model.Tour;

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
        Admin admin = adminlogin.loginAdmin(name, password);
        if (admin == null) {
            System.out.println("Invalid");
            return;
        }

        TourController tourController = new TourController();

        while (true) {
            System.out.println("\nWELCOME ADMIN " + admin.getAdminName());
            System.out.println("1 - CREATE TOUR");
            System.out.println("2 - VIEW ALL TOURS");
            System.out.println("3 - UPDATE TOUR");
            System.out.println("4 - DELETE TOUR");
            System.out.println("5 - EXIT");
            System.out.print("Enter your choice: ");

            int n = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (n) {
                case 1:
                    System.out.println("Enter Location:");
                    String tourlocation = sc.nextLine();
                    System.out.println("Number of days:");
                    int days = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Price:");
                    int tourprice = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    if (tourController.addTour(days, tourlocation, tourprice)) {
                        System.out.println("Tour added successfully!");
                    } else {
                        System.out.println("Failed to add tour.");
                    }
                    break;

                case 2:
                    // **DISPLAY ALL TOURS**
                    List<Tour> t = tourController.getTours();
                    if (t.isEmpty()) {
                        System.out.println("No tours available.");
                    } else {
                        System.out.println("\n------ TOUR LIST ------");
                        for (Tour tour : t) {
                            System.out.println("ID: " + tour.getTourId() +
                                    " | Location: " + tour.getLocation() +
                                    " | Price: $" + tour.getPrice());
                        }
                    }
                    break;

                case 3:

                    List<Tour> tourss = tourController.getTours();
                    if (tourss.isEmpty()) {
                        System.out.println("No tours available.");
                    } else {
                        System.out.println("\n------ TOUR LIST ------");
                        for (Tour tour : tourss) {
                            System.out.println("ID: " + tour.getTourId() +
                                    " | Days: " + tour.getDays() +
                                    " | Location: " + tour.getLocation() +
                                    " | Price: $" + tour.getPrice());
                        }
                    }
                    System.out.println("------------ ENTER THE VALUES TO UPDATE TOUR ---------------");
                    System.out.println("Enter id: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter location: ");
                    String updateLocation = sc.nextLine();
                    System.out.println("Number of Days: ");
                    int updatedays = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Price: ");
                    int updatePrice = sc.nextInt();

                    if (tourController.updateTour(updateId, updatedays, updateLocation, updatePrice)) {
                        System.out.println("updated successfully");
                    } else {
                        System.out.println("No change");
                    }
                    break;

                case 4:
                    List<Tour> tours = tourController.getTours();
                    if (tours.isEmpty()) {
                        System.out.println("No tours available.");
                    } else {
                        System.out.println("\n------ TOUR LIST ------");
                        for (Tour tour : tours) {
                            System.out.println("ID: " + tour.getTourId() +
                                    " | Days: " + tour.getDays() +
                                    " | Location: " + tour.getLocation() +
                                    " | Price: $" + tour.getPrice());
                        }
                    }
                    System.out.println("------------ ENTER THE ID TO DELETE TOUR ---------------");
                    int deleteId = sc.nextInt();
                    if (tourController.deleteTour(deleteId)) {
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("No tour is deleted");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Admin Panel...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
