/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week8;

import java.util.List;

/**
 *
 * @author ASUS
 */
public class MainApp {

    private static final CandidateService service = new CandidateService();

    public static void main(String[] args) {
        String[] options = {"Experience", "Fresher", "Internship", "Searching", "Exit"};
        while (true) {
            initSampleData();
            service.printGrouped();
            int op = Validate.menu("CANDIDATE MANAGEMENT SYSTEM", options);

            switch (op) {
                case 1:
                    createExperience();
                    break;
                case 2:
                    createFresher();
                    break;
                case 3:
                    createIntern();
                    break;
                case 4:
                    searchFlow();
                    break;
                case 5:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Please choose 1..5");
            }
        }
    }

    private static void initSampleData() {
        service.add(new Experience("E001", "John", "Smith", 1990, "Hanoi", "0987654321", "john@gmail.com", 5, "Java"));
        service.add(new Experience("E002", "Linh", "Tran", 1988, "Da Nang", "0911222333", "linhtran@yahoo.com", 10, "C#"));
        service.add(new Fresher("F001", "Mai", "Nguyen", 1999, "HCM", "0909999999", "mainguyen@gmail.com", 2023, "Good", "FPT University"));
        service.add(new Fresher("F002", "Huy", "Pham", 2000, "Hue", "0933333333", "huypham@gmail.com", 2024, "Excellence", "HUE University"));
        service.add(new Intern("I001", "An", "Le", 2002, "Can Tho", "0944444444", "anle@gmail.com", "IoT", 7, "FPTU Can Tho"));
        service.add(new Intern("I002", "Tuan", "Vo", 2003, "Hanoi", "0955555555", "tuanvo@gmail.com", "AI", 5, "PTIT"));
    }

    private static void createExperience() {
        do {
            System.out.println("=== Create Experience Candidate ===");

            String id = Validate.inputUntilValid("Candidate ID: ", s -> Validate.requireNonEmpty(s, "Candidate ID"));
            String first = Validate.inputUntilValid("First name: ", s -> Validate.requireNonEmpty(s, "First name"));
            String last = Validate.inputUntilValid("Last name: ", s -> Validate.requireNonEmpty(s, "Last name"));
            int birth = Integer.parseInt(Validate.inputUntilValid("Birth year (yyyy): ", s -> String.valueOf(Validate.requireBirthYear(s))));
            String addr = Validate.inputUntilValid("Address: ", s -> Validate.requireNonEmpty(s, "Address"));
            String phone = Validate.inputUntilValid("Phone (>=10 digits): ", Validate::requirePhone);
            String email = Validate.inputUntilValid("Email: ", Validate::requireEmail);
            int exp = Integer.parseInt(Validate.inputUntilValid("Years of experience (0..100): ", s -> String.valueOf(Validate.requireExpInYear(s))));
            String skill = Validate.inputUntilValid("Professional skill: ", s -> Validate.requireNonEmpty(s, "Professional skill"));

            service.add(new Experience(id, first, last, birth, addr, phone, email, exp, skill));
            System.out.println("Created successfully!");
        } while (Validate.askYesNo("Do you want to continue (Y/N)? "));
        service.printGrouped();
    }

    private static void createFresher() {
        do {
            System.out.println("=== Create Fresher Candidate ===");

            String id = Validate.inputUntilValid("Candidate ID: ", s -> Validate.requireNonEmpty(s, "Candidate ID"));
            String first = Validate.inputUntilValid("First name: ", s -> Validate.requireNonEmpty(s, "First name"));
            String last = Validate.inputUntilValid("Last name: ", s -> Validate.requireNonEmpty(s, "Last name"));
            int birth = Integer.parseInt(Validate.inputUntilValid("Birth year (yyyy): ", s -> String.valueOf(Validate.requireBirthYear(s))));
            String addr = Validate.inputUntilValid("Address: ", s -> Validate.requireNonEmpty(s, "Address"));
            String phone = Validate.inputUntilValid("Phone (>=10 digits): ", Validate::requirePhone);
            String email = Validate.inputUntilValid("Email: ", Validate::requireEmail);
            int gradYear = Integer.parseInt(Validate.inputUntilValid("Graduation year (yyyy): ", s -> String.valueOf(Validate.requireBirthYear(s))));
            String rank = Validate.inputUntilValid("Graduation rank (Excellence/Good/Fair/Poor): ", Validate::requireRank);
            String edu = Validate.inputUntilValid("Education (University): ", s -> Validate.requireNonEmpty(s, "Education"));

            service.add(new Fresher(id, first, last, birth, addr, phone, email, gradYear, rank, edu));
            System.out.println("Created successfully!");
        } while (Validate.askYesNo("Do you want to continue (Y/N)? "));
        service.printGrouped();
    }

    private static void createIntern() {
        do {
            System.out.println("=== Create Intern Candidate ===");

            String id = Validate.inputUntilValid("Candidate ID: ", s -> Validate.requireNonEmpty(s, "Candidate ID"));
            String first = Validate.inputUntilValid("First name: ", s -> Validate.requireNonEmpty(s, "First name"));
            String last = Validate.inputUntilValid("Last name: ", s -> Validate.requireNonEmpty(s, "Last name"));
            int birth = Integer.parseInt(Validate.inputUntilValid("Birth year (yyyy): ", s -> String.valueOf(Validate.requireBirthYear(s))));
            String addr = Validate.inputUntilValid("Address: ", s -> Validate.requireNonEmpty(s, "Address"));
            String phone = Validate.inputUntilValid("Phone (>=10 digits): ", Validate::requirePhone);
            String email = Validate.inputUntilValid("Email: ", Validate::requireEmail);
            String majors = Validate.inputUntilValid("Majors: ", s -> Validate.requireNonEmpty(s, "Majors"));
            int semester = Integer.parseInt(Validate.inputUntilValid("Semester (number): ", s -> String.valueOf(Validate.requireInt(s, "Semester"))));
            String uni = Validate.inputUntilValid("University name: ", s -> Validate.requireNonEmpty(s, "University name"));

            service.add(new Intern(id, first, last, birth, addr, phone, email, majors, semester, uni));
            System.out.println("Created successfully!");
        } while (Validate.askYesNo("Do you want to continue (Y/N)? "));
        service.printGrouped();
    }

    private static void searchFlow() {
        service.printGrouped();
        String key = Validate.ask("Input Candidate name (First name or Last name): ");
        int type = Validate.readInt("Input type of candidate (0-Exp, 1-Fresher, 2-Intern): ");
        List<Candidate> rs = service.searchByNameAndType(key, type);
        System.out.println("\nThe candidates found:");
        if (rs.isEmpty()) {
            System.out.println("(No result)");
        } else {
            rs.forEach(c -> System.out.println(c.toString()));
        }
    }

}
