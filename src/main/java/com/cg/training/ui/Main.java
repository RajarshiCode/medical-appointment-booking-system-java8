package com.cg.training.ui;

import java.util.Scanner;

import com.cg.training.exceptions.InvalidAppointmentException;
import com.cg.training.models.Admin;
import com.cg.training.models.Patient;
import com.cg.training.service.AppointmentSystem;

/**
 * This is the main user interface class for the Medical Appointment System.
 * It allows the user to act as either a Doctor or a Patient and perform
 * different operations such as registration, booking appointments, and managing them.
 * 
 * Author: Rishiraj Ray 
 */
public class Main {
    
    /**
     * The main method is the entry point of the application.
     * It uses a simple text-based menu to interact with the user.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        AppointmentSystem system = new AppointmentSystem();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Medical Appointment System");
        System.out.println();

        try {
            // Main loop for selecting user role
            while (true) {
                System.out.println("Are you a:");
                System.out.println("1. Doctor\n2. Patient\n3. Exit");
                System.out.print("Choose option (1, 2, or 3): ");
                String roleChoice = sc.nextLine();

                // Doctor menu
                if (roleChoice.equals("1")) {
                    while (true) {
                        System.out.println("\nDoctor Menu:");
                        System.out.println("1. Register a Doctor");
                        System.out.println("2. Show All Appointments");
                        System.out.println("3. Complete Appointment");
                        System.out.println("4. Remove a Doctor");
                        System.out.println("5. Exit");
                        System.out.print("Enter choice: ");
                        String doctorChoice = sc.nextLine();

                        switch (doctorChoice) {
                            case "1":
                                System.out.print("Enter Doctor Name: ");
                                String dname = sc.nextLine();
                                system.registerDoctor(dname);
                                break;

                            case "2":
                                System.out.print("Enter your Doctor ID (e.g., D1001): ");
                                String docId = sc.nextLine();
                                system.showAppointmentsByDoctorId(docId);
                                break;

                            case "3":
                                system.showAllAppointments();
                                System.out.print("Enter appointment index to complete: ");
                                try {
                                    int index = Integer.parseInt(sc.nextLine());
                                    system.completeAppointment(index);
                                    system.saveAppointmentsToFile();
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid index. Must be a number.");
                                }
                                break;

                            case "4":
                                System.out.print("Enter Doctor ID to remove (e.g., D1001): ");
                                String doctorId = sc.nextLine();
                                Admin admin = new Admin("A1", "Admin");
                                admin.removeDoctor(system.doctors, doctorId);
                                break;

                            case "5":
                                System.out.println("Going back to main menu!!");
                                break;

                            default:
                                System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                                break;
                        }
                        if (doctorChoice.equals("5")) break;
                    }

