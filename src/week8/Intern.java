/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week8;

/**
 *
 * @author ASUS
 */
public class Intern extends Candidate {

    private String majors;
    private int semester;
    private String universityName;

    public Intern(String candidateId, String firstName, String lastName, int birthYear,
            String address, String phone, String email,
            String majors, int semester, String universityName) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, 2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public String brief() {
        return getFullName();
    }
}
