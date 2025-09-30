/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4;

import java.util.Scanner;
import static week4.Validate.*;

/**
 *
 * @author ASUS
 */
public class test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement stm = new StudentManagement();
        String[] options = {"Create", "Find and Sort", "Update/Delete", "Report", "Exit"};
        while (true) {
            int choice = menu("WELCOME TO STUDENT MANAGEMENT", options);
            switch (choice) {
                case 1:
                    int count = 0;
                    while (true) {
                        System.out.print("ID: ");
                        String id = sc.nextLine().trim();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Semester: ");
                        String semester = sc.nextLine();

                        String course;
                        while (true) {
                            System.out.print("Course (Java/.Net/C/C++): ");
                            course = sc.nextLine().trim();
                            if (course.equalsIgnoreCase("Java")
                                    || course.equalsIgnoreCase(".Net")
                                    || course.equalsIgnoreCase("C/C++")) {
                                break;
                            }
                            System.out.println("Invalid course! Please enter Java, .Net or C/C++");
                        }

                        boolean check = stm.addStudent(new Student1(id, name, semester, course));
                        if (check) {
                            count++;
                        } else {
                            System.out.println("This student already registered this course in this semester!");
                        }

                        if (count >= 3) {
                            System.out.print("Do you want to continue (Y/N)? ");
                            String cont = sc.nextLine().trim();
                            if (cont.equalsIgnoreCase("N")) {
                                break;
                            }
                        }
                    }
                    stm.showStudent();
                    break;

                case 2:
                    stm.sortStudent();
                    break;
                case 3:
                    System.out.println("Do you want Delete(D) or Update(U) (D/U): ");
                    String op = sc.nextLine().trim().toLowerCase();
                    if (op.equalsIgnoreCase("d")) {
                        System.out.println("Enter Student ID to delete: ");
                        String id = sc.nextLine().trim();
                        stm.deleteStudent(id);
                        stm.showStudent();
                    }
                    if (op.equalsIgnoreCase("u")) {
                        System.out.println("Enter ID to update: ");
                        String id = sc.nextLine().trim();
                        System.out.println("Update Name: ");
                        String name = sc.nextLine();
                        System.out.println("Update Semester: ");
                        String semester = sc.nextLine();
                        System.out.println("Update Course: ");
                        String course = sc.nextLine();
                        stm.updateStudent(id, name, semester, course);
                        stm.showStudent();
                    }
                    break;
                case 4:
                    stm.reportStudent();
                    break;
                case 5:
                    System.out.println("Thank you!!!");
                    return;

            }
        }
    }

}
