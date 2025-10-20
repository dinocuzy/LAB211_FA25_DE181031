/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ASUS
 */
public class OfflineCourse extends Course {

    private LocalDate begin;
    private LocalDate end;
    private String campus;

    public OfflineCourse() {
        super();
        this.begin = null;
        this.end = null;
        this.campus = "";
    }

    public OfflineCourse(String id, String name, int credits,
            LocalDate begin, LocalDate end, String campus) {
        super(id, name, credits);
        this.begin = begin;
        this.end = end;
        this.campus = campus;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String getCampus() {
        return campus;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return courseID + "-" + courseName + "-" + credits + "-"
                + begin.format(fmt) + "-" + end.format(fmt) + "-" + campus;
    }
}
