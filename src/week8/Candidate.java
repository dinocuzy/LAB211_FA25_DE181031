/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week8;

/**
 *
 * @author ASUS
 */
public abstract class Candidate {

    protected String candidateId;
    protected String firstName;
    protected String lastName;
    protected int birthYear;
    protected String address;
    protected String phone;
    protected String email;
    protected int candidateType;

    public Candidate(String candidateId, String firstName, String lastName, int birthYear,
            String address, String phone, String email, int candidateType) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public abstract String brief();

    @Override
    public String toString() {
        return String.format("%s | %d | %s | %s | %s | %d",
                getFullName(), birthYear, address, phone, email, candidateType);
    }
}
