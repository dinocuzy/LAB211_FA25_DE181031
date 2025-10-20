/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5;

/**
 *
 * @author ASUS
 */

public class Course {
    protected String courseID;
    protected String courseName;
    protected int credits;

    public Course() {
        this.courseID = "";
        this.courseName = "";
        this.credits = 0;
    }

    public Course(String id, String name, int credits) {
        this.courseID = id;
        this.courseName = name;
        this.credits = credits;
    }

    public String getCourseID() { return courseID; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }

    public void setCourseID(String id) { this.courseID = id; }
    public void setCourseName(String name) { this.courseName = name; }
    public void setCredits(int credits) { this.credits = credits; }

    @Override
    public String toString() {
        return courseID + "-" + courseName + "-" + credits;
    }
}
