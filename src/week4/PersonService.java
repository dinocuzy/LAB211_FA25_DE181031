/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */

public class PersonService {
    private List<Person> people = new ArrayList<>();

    public void add(Person p) {
        people.add(p);
    }

    public void printTeachers() {
        int idx = 1;
        boolean empty = true;
        for (Person p : people) {
            if (p instanceof Teacher) {
                if (empty) {
                    System.out.println("# - ID - Fullname - Phone - YOB - Major - Years - Contract - SalaryCoef");
                    empty = false;
                }
                System.out.println(idx++ + " - " + p);
            }
        }
        if (empty) {
            System.out.println("No teacher data!");
        }
    }

    public void printStudents() {
        int idx = 1;
        boolean empty = true;
        for (Person p : people) {
            if (p instanceof Student) {
                if (empty) {
                    System.out.println("# - ID - Fullname - Phone - YOB - Major - YearAdmission - EnglishScore");
                    empty = false;
                }
                System.out.println(idx++ + " - " + p);
            }
        }
        if (empty) {
            System.out.println("No student data!");
        }
    }
    
    public void printAllPersons() {
        if (people.isEmpty()) {
            System.out.println("No data!");
        } else {
            System.out.println("# - ID - Fullname - Phone - YOB - Major");
            int idx = 1;
            for (Person p : people) {
                System.out.println(idx++ + " - " + p.toString());
            }
        }
    }

    public void searchByName(String keyword) {
        boolean found = false;
        keyword = keyword.toLowerCase();

        for (Person p : people) {
            if (p.getName().toLowerCase().contains(keyword)) {
                if (!found) {
                    System.out.println("# - ID - Fullname - Phone - YOB - Major");
                    found = true;
                }
                System.out.println(p.toString());
            }
        }

        if (!found) {
            System.out.println("Result: not found");
        }
    }

    public List<Person> getPeople() {
        return people;
    }
}

