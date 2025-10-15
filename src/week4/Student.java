/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4;

/**
 *
 * @author ASUS
 */
public class Student extends Person {

    private int yearOfAdmission;
    private double entranceEnglishScore;

    public Student() {
    }

    public Student(String id, String name, String phone, int yob, String major, int yearOfAdmission, double entranceEnglishScore) {
        super(id, name, phone, yob, major);
        this.yearOfAdmission = yearOfAdmission;
        this.entranceEnglishScore = entranceEnglishScore;
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public double getEntranceEnglishScore() {
        return entranceEnglishScore;
    }

    public void setEntranceEnglishScore(double entranceEnglishScore) {
        this.entranceEnglishScore = entranceEnglishScore;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d - %s - %d - %.1f",
                super.getId(), super.getName(), super.getPhone(), super.getYob(), super.getMajor(),
                yearOfAdmission, entranceEnglishScore);
    }

}
