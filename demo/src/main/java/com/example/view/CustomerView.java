package com.example.view;

import java.util.*;

import com.example.controller.BookingController;
import com.example.controller.CustomerController;
import com.example.controller.TourController;
import com.example.model.Booking;
import com.example.model.Customer;
import com.example.model.Tour;

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
                Customer customer = controller.loginCustomer(number, password);
                if (customer != null) {
                    System.out.println("---------- login successfull -----------");

                    System.out.println("1 - BOOK TOUR\n2 - CANCEL TOUR\n3 - SHOW TOURS");
                    int n = sc.nextInt();
                    TourController showTour = new TourController();
                    BookingController bookcontroller = new BookingController();
                    switch (n) {
                        case 1: {
                            List<Tour> tours = showTour.getTours();
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
                            System.out.println("SELECT THE TOUR ID TO BOOK TOUR");
                            int tid = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Number of persons");
                            int tot = sc.nextInt();
                            sc.nextLine();
                            if (bookcontroller.createBooking(tid, tot, customer.getCustomerId())) {
                                System.out.println("BOOKING SUCCESSFULL");
                            } else {
                                System.out.println("BOOKING UNSUCCESSFULL");
                            }
                            break;
                        }
                        case 2: {
                            List<Booking> myBookings = bookcontroller.showMyBookings(customer.getCustomerId());
                            if (myBookings.isEmpty()) {
                                System.out.println("No bookings found for this customer.");
                            } else {
                                System.out.println("\n------ YOUR BOOKINGS ------");
                                for (Booking booking : myBookings) {
                                    System.out.println("Booking ID: " + booking.getBookingId() +
                                            " | Location: " + booking.getLocation() +
                                            " | Days: " + booking.getNoOfDays() +
                                            " | Persons: " + booking.getNoOfPersons() +
                                            " | Total Price: $" + booking.getTotalPrice());
                                }
                                System.out.println("SELECT BOOKING ID TO DELETE");
                                int idtoDelete = sc.nextInt();
                                sc.nextLine();
                                if (bookcontroller.deleteBooking(idtoDelete)) {
                                    System.out.println("Deleted");
                                } else {
                                    System.out.println("Not deleted");
                                }
                                break;
                            }
                        }
                        case 3: {
                            List<Booking> myBookings = bookcontroller.showMyBookings(customer.getCustomerId());
                            if (myBookings.isEmpty()) {
                                System.out.println("No bookings found for this customer.");
                            } else {
                                System.out.println("\n------ YOUR BOOKINGS ------");
                                for (Booking booking : myBookings) {
                                    System.out.println("Booking ID: " + booking.getBookingId() +
                                            " | Location: " + booking.getLocation() +
                                            " | Days: " + booking.getNoOfDays() +
                                            " | Persons: " + booking.getNoOfPersons() +
                                            " | Total Price: $" + booking.getTotalPrice());
                                }
                            }
                            break;
                        }
                        default: {
                            System.out.println("Give valid input");
                            break;
                        }
                    }

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
