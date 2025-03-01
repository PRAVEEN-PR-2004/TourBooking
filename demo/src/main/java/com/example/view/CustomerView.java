package com.example.view;

import java.util.Scanner;
import com.example.controller.CustomerController;

public class CustomerView {
    public void customerInterface() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- WELCOME ----------");
        System.out.println("1 - Login");
        System.out.println("2 - Signup");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        CustomerController controller = new CustomerController();

        switch (choice) {
            case 1:
                System.out.print("Enter your number: ");
                String number = sc.nextLine();
                System.out.print("Enter your password: ");
                String password = sc.nextLine();
                if (controller.loginCustomer(number, password)) {

                } else {
                    System.out.println("LOGIN FAILED");
                }

                break;
            case 2:
                System.out.print("Enter you name: ");
                String name1 = sc.next();
                sc.nextLine();
                System.out.print("Enter your number: ");
                String number1 = sc.next();
                sc.nextLine();
                System.out.print("Enter your password: ");
                String password1 = sc.next();
                controller.signupCustomer(name1, number1, password1);
                customerInterface();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

}
