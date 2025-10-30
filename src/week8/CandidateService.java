/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week8;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CandidateService {

    private final List<Candidate> list = new ArrayList<>();

    public void add(Candidate c) {
        list.add(c);
    }

    public List<Candidate> getAll() {
        return list;
    }

    public List<Candidate> searchByNameAndType(String name, int type) {
        String key = name.toLowerCase(); 
        List<Candidate> result = new ArrayList<>();
        for (Candidate c : list) {
            if (c.getCandidateType() == type
                    && c.getFullName().toLowerCase().contains(key)) {
                result.add(c);
            }
        }
        return result;
    }

    public void printGrouped() {
        System.out.println("List of candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate c : list) {
            if (c.getCandidateType() == 0) {
                System.out.println(c.brief());
            }
        }

        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidate c : list) {
            if (c.getCandidateType() == 1) {
                System.out.println(c.brief());
            }
        }

        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate c : list) {
            if (c.getCandidateType() == 2) {
                System.out.println(c.brief());
            }
        }
    }
}
