/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4;

/**
 *
 * @author ASUS
 */
public class Person {

    private String id;
    private String name;
    private String phone;
    private int yob;
    private String major;

    public Person() {
    }

    public Person(String id, String name, String phone, int yob, String major) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.yob = yob;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void inputAll() {

    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d - %s",
                id, name, phone, yob, major);
    }

}
