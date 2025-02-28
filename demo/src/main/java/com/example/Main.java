package com.example;

import java.util.Scanner;

import com.example.view.AdminView;
import com.example.view.CustomerView;
// import com.example.view.AdminView; // Create this for Admin operations

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // while (true) { // Keep asking until valid input
        System.out.println("Are you a:");
        System.out.println("1 - Customer");
        System.out.println("2 - Admin");
        System.out.println("3 - Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                CustomerView customerView = new CustomerView();
                customerView.customerInterface(); // Calls the Customer View
                break;
            case 2:
                AdminView adminView = new AdminView();
                adminView.adminInterface(); // Calls the Admin View (create this)
                break;
            case 3:
                System.out.println("Exiting the application...");
                sc.close();
                return; // Ends the program
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        // }
    }
}
