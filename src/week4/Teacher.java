/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4;

/**
 *
 * @author ASUS
 */
public class Teacher extends Person {

    private int yearsInProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher() {
    }

    ;

    public Teacher(String id, String name, String phone, int yob, String major, int yearsInProfession, String contractType, double salaryCoefficient) {
        super(id, name, phone, yob, major);
        this.yearsInProfession = yearsInProfession;
        this.contractType = contractType;
        this.salaryCoefficient = salaryCoefficient;
    }

    public int getYearsInProfession() {
        return yearsInProfession;
    }

    public void setYearsInProfession(int yearsInProfession) {
        this.yearsInProfession = yearsInProfession;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d - %s - %d - %s - %.2f",
                getId(), getName(), getPhone(), getYob(), getMajor(),
                yearsInProfession, contractType, salaryCoefficient);
    }

    
}
