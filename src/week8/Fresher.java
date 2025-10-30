/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week8;

/**
 *
 * @author ASUS
 */
public class Fresher extends Candidate {

    private int graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String candidateId, String firstName, String lastName, int birthYear,
            String address, String phone, String email,
            int graduationDate, String graduationRank, String education) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public String brief() {
        return getFullName();
    }
}
