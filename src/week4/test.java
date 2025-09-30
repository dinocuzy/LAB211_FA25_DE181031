/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4;

import java.util.ArrayList;
import java.util.List;
import static week4.Validate.*;

/**
 *
 * @author ASUS
 */
public class test {

    public static void main(String[] args) {
        PersonService service = new PersonService();

        String[] options = {"Teacher", "Student", "Person", "Exit"};
        while (true) {
            int choice = menu("*** Information Management ***", options);
            switch (choice) {
                
                case 1:
                    String[] teacherOps = {"Input", "Print", "Exit"};
                    while (true) {
                        int ch = menu("*** Teacher Management ***", teacherOps);
                        switch (ch) {
                            case 1:
                                String tid = isValidID("ID: ");
                                String tname = inputName("Fullname: ");
                                String tphone = isPhone("Phone number: ");
                                int tyob = isYOB("Year of birth: ");
                                String tmajor = isMajor("Major: ");
                                int tyears = isYears("Years in profession: ", tyob);
                                String tcontract = isContractType("Contract type: ");
                                double tcoef = isSalaryCoefficient("Salary coefficient: ");
                                service.add(new Teacher(tid, tname, tphone, tyob, tmajor,
                                        tyears, tcontract, tcoef));
                                System.out.println("Teacher added successfully!");
                                break;
                            case 2:
                                service.printTeachers();
                                break;
                            case 3:
                                System.out.println("Back to main menu...");
                                break;
                        }
                        if (ch == 3) {
                            break;
                        }
                    }
                    break;

                
                case 2:
                    String[] studentOps = {"Input", "Print", "Exit"};
                    while (true) {
                        int ch = menu("*** Student Management ***", studentOps);
                        switch (ch) {
                            case 1:
                                String sid = isValidID("ID: ");
                                String sname = inputName("Fullname: ");
                                String sphone = isPhone("Phone number: ");
                                int syob = isYOB("Year of birth: ");
                                String smajor = isMajor("Major: ");
                                int sadmission = isYears("Year of admission: ", syob);
                                double sscore = isEntranceEnglishScore("Entrance English score: ");
                                service.add(new Student(sid, sname, sphone, syob, smajor,
                                        sadmission, sscore));
                                System.out.println("Student added successfully!");
                                break;
                            case 2:
                                service.printStudents();
                                break;
                            case 3:
                                System.out.println("Back to main menu...");
                                break;
                        }
                        if (ch == 3) {
                            break;
                        }
                    }
                    break;

                case 3:
                    String[] personOps = {"Search", "Print all", "Exit"};
                    while (true) {
                        int ch = menu("*** Person Management ***", personOps);
                        switch (ch) {
                            case 1:
                                System.out.print("Name: ");
                                String keyword = sc.nextLine().trim();
                                service.searchByName(keyword);
                                break;
                            case 2:
                                service.printAllPersons();
                                break;
                            case 3:
                                System.out.println("Back to main menu...");
                                break;
                        }
                        if (ch == 3) {
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    return;
            }
        }
    }
}
