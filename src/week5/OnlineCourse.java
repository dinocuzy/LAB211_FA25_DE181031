/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5;

/**
 *
 * @author ASUS
 */
public class OnlineCourse extends Course {

    private String platform;
    private String instructors;
    private String note;

    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }

    public OnlineCourse(String id, String name, int credits,
            String platform, String instructors, String note) {
        super(id, name, credits);
        this.platform = platform;
        this.instructors = instructors;
        this.note = note;
    }

    public String getPlatform() {
        return platform;
    }

    public String getInstructors() {
        return instructors;
    }

    public String getNote() {
        return note;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return courseID + "-" + courseName + "-" + credits + "-"
                + platform + "-" + instructors + "-" + note;
    }
}
