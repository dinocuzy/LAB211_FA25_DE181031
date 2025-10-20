/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CourseManagement {

    private final List<Course> courses = new ArrayList<>();

    public boolean addCourse(Course c) {
        if (c == null || !isUniqueID(c.getCourseID())) {
            return false;
        }
        courses.add(c);
        return true;
    }

    public boolean updateCourse(String id, Course newCourse) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equalsIgnoreCase(id)) {
                courses.set(i, newCourse);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(String id) {
        return courses.removeIf(c -> c.getCourseID().equalsIgnoreCase(id));
    }

    public Course findCourseById(String id) {
        for (Course c : courses) {
            if (c.getCourseID().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    public boolean isUniqueID(String id) {
        for (Course c : courses) {
            if (c.getCourseID().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    public List<Course> getAll() {
        return courses;
    }

    public void printCourses(String type) {
        if (courses.isEmpty()) {
            System.out.println("No information to view");
            return;
        }

        switch (type.toUpperCase()) {
            case "A" -> {
                System.out.println("Course ID-Course name-Credits");
                for (Course c : courses) {
                    System.out.println(c);
                }
            }
            case "O" -> {
                System.out.println("Course ID-Course name-Credits-Platform-Instructors-Note");
                for (Course c : courses) {
                    if (c instanceof OnlineCourse) {
                        System.out.println(c);
                    }
                }
            }
            case "F" -> {
                System.out.println("Course ID-Course name-Credits-Begin-End-Campus");
                for (Course c : courses) {
                    if (c instanceof OfflineCourse) {
                        System.out.println(c);
                    }
                }
            }
            default ->
                System.out.println("Invalid type");
        }
    }
}
