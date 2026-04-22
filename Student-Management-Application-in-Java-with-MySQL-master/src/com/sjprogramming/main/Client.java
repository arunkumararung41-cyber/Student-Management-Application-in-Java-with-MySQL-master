package com.sjprogramming.main;

import com.sjprogramming.dao.*;
import com.sjprogramming.model.Student;
import com.sjprogramming.util.Validator;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDaoInterface dao = new StudentDao();

        // ================= LOGIN =================
        System.out.println("=================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM   ");
        System.out.println("=================================");

        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (!dao.login(user, pass)) {
            System.out.println("❌ Invalid credentials! Exiting...");
            return;
        }

        System.out.println("✅ Login Successful!\n");

        // ================= MENU =================
        while (true) {

            System.out.println("\n=================================");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Get Student by ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.println("7. Search Student by Name");
            System.out.println("8. Sort Students by Percentage");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            int ch;

            try {
                ch = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("❌ Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            switch (ch) {

                // ===== ADD =====
                case 1:
                    System.out.println("\n--- Add Student ---");

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    if (!Validator.isValidName(name)) {
                        System.out.println("❌ Invalid name (min 3 characters)");
                        break;
                    }

                    System.out.print("Enter College Name: ");
                    String clg = sc.nextLine();

                    System.out.print("Enter City: ");
                    String city = sc.nextLine();

                    System.out.print("Enter Percentage: ");
                    double per;

                    try {
                        per = sc.nextDouble();
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("❌ Invalid percentage!");
                        sc.nextLine();
                        break;
                    }

                    if (!Validator.isValidPercentage(per)) {
                        System.out.println("❌ Percentage must be 0–100");
                        break;
                    }

                    boolean added = dao.insertStudent(new Student(name, clg, city, per));

                    if (added)
                        System.out.println("✅ Student added successfully!");
                    else
                        System.out.println("❌ Failed to add student");

                    break;

                // ===== SHOW ALL =====
                case 2:
                    System.out.println("\n--- All Students ---");
                    dao.showAllStudent();
                    break;

                // ===== GET BY ID =====
                case 3:
                    System.out.print("\nEnter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean found = dao.showStudentById(id);

                    if (!found)
                        System.out.println("❌ Student not found");

                    break;

                // ===== DELETE =====
                case 4:
                    System.out.print("\nEnter Student ID to delete: ");
                    int delId = sc.nextInt();
                    sc.nextLine();

                    boolean deleted = dao.delete(delId);

                    if (deleted)
                        System.out.println("✅ Student deleted successfully");
                    else
                        System.out.println("❌ Delete failed");

                    break;

                // ===== UPDATE =====
                case 5:
                    System.out.println("\n--- Update Student ---");
                    System.out.println("1. Update Name");
                    System.out.println("2. Update College Name");
                    System.out.print("Enter choice: ");

                    int choice = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new value: ");
                    String value = sc.nextLine();

                    boolean updated = dao.update(uid, value, choice);

                    if (updated)
                        System.out.println("✅ Updated successfully");
                    else
                        System.out.println("❌ Update failed");

                    break;

                // ===== SEARCH =====
                case 6:
                    System.out.print("\nEnter name to search: ");
                    String search = sc.nextLine();

                    boolean result = dao.searchByName(search);

                    if (!result)
                        System.out.println("❌ No student found");

                    break;

                // ===== SORT =====
                case 7:
                    System.out.println("\n--- Students Sorted by Percentage ---");
                    dao.sortByPercentage();
                    break;
                    
                    // ===== EXIT =====
                case 8:
                    System.out.println("🙏 Thank you for using the system!");
                    System.exit(0);

                // ===== INVALID =====
                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}