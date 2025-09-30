/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static week4.Validate.*;

/**
 *
 * @author ASUS
 */
public class StudentManagement {

    private List<Student1> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public boolean addStudent(Student1 student) {
        for (Student1 s : students) {
            if (student.getId().equalsIgnoreCase(s.getId()) && student.getSemester().equalsIgnoreCase(s.getSemester()) && student.getCourseName().equalsIgnoreCase(s.getCourseName())) {
                return false;
            }
        }
        return students.add(student);
    }

    public void showStudent() {
        for (Student1 s : students) {
            System.out.println(s);
        }
    }

    public void deleteStudent(String Id) {
        for (Student1 s : students) {
            if (s.getId().equalsIgnoreCase(Id)) {
                students.remove(s);
                return;
            }
        }
        System.out.println("Not have this Student ID in list!!!");
    }

    public void updateStudent(String id, String newName, String newSemester, String newCourse) {
        for (Student1 s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                s.setStudentName(newName);
                s.setSemester(newSemester);
                s.setCourseName(newCourse);
            }
        }
    }

    public void sortStudent() {
        students.sort(Comparator.comparing(Student1::getStudentName));
        showStudent();
    }

    public void findStudent(String keyword) {
        List<Student1> result = new ArrayList<>();
        keyword = keyword.toLowerCase();

        for (Student1 s : students) {
            if (s.getStudentName().toLowerCase().contains(keyword)) {
                result.add(s);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No student found!");
            return;
        }

        result.sort(Comparator.comparing(Student1::getStudentName));

        System.out.println("Student name | Semester | Course");
        for (Student1 s : result) {
            System.out.println(s.getStudentName() + " | " + s.getSemester() + " | " + s.getCourseName());
        }
    }

    public void reportStudent() {
        Map<String, Integer> report = new HashMap<>();
        for (Student1 s : students) {
            String key = s.getId() + "|" + s.getStudentName() + "|" + s.getCourseName();
            report.put(key, report.getOrDefault(key, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : report.entrySet()) {
            String[] parts = e.getKey().split("\\|");
            System.out.println(parts[0] + " | " + parts[1] + " | " + parts[2] + " | " + e.getValue()
            );
        }
    }

}
