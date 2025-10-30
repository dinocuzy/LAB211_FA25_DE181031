/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5;

import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class TestCourse {

    public static void main(String[] args) {
        CourseManagement cm = new CourseManagement();
        int choice;

        do {
            System.out.println("\n*** Course Management ***");
            System.out.println("1. Add online course/ offline course");
            System.out.println("2. Update course");
            System.out.println("3. Delete course");
            System.out.println("4. Print all / online course / offline course");
            System.out.println("5. Search information base on course name");
            System.out.println("6. Exit");
            System.out.print("You choose: ");

            try {
                choice = Integer.parseInt(Validate.sc.nextLine().trim());
            } catch (Exception e) {
                choice = -1;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("*** Add new course ***");
                    String type;
                    do {
                        System.out.print("Online (O) or Offline (F): ");
                        type = Validate.sc.nextLine().trim();
                        if (!type.equalsIgnoreCase("O") && !type.equalsIgnoreCase("F")) {
                            System.out.println("Data input is invalid");
                        }
                    } while (!type.equalsIgnoreCase("O") && !type.equalsIgnoreCase("F"));

                    if (type.equalsIgnoreCase("O")) {
                        String id = Validate.inputNonEmpty("Course ID: ");
                        while (!cm.isUniqueID(id)) {
                            System.out.println("Data input is invalid, ID must be unique");
                            id = Validate.inputNonEmpty("Course ID: ");
                        }
                        String name = Validate.inputNonEmpty("Course name: ");
                        int credits = Validate.inputPositiveInt("Credits: ");
                        String platform = Validate.inputNonEmpty("Platform: ");
                        System.out.print("Instructors: ");
                        String ins = Validate.sc.nextLine().trim();
                        String note = Validate.inputNonEmpty("Note: ");
                        OnlineCourse oc = new OnlineCourse(id, name, credits, platform, ins, note);
                        cm.addCourse(oc);
                    } else {
                        String id = Validate.inputNonEmpty("Course ID: ");
                        while (!cm.isUniqueID(id)) {
                            System.out.println("Data input is invalid, ID must be unique");
                            id = Validate.inputNonEmpty("Course ID: ");
                        }
                        String name = Validate.inputNonEmpty("Course name: ");
                        int credits = Validate.inputPositiveInt("Credits: ");
                        LocalDate begin = Validate.inputFutureDate("Begin (d/M/yyyy): ");
                        LocalDate end;
                        while (true) {
                            end = Validate.inputFutureDate("End (d/M/yyyy): ");
                            if (end.isAfter(begin)) {
                                break;
                            }
                            System.out.println("Data input is invalid, end must be after begin");
                        }
                        String campus = Validate.inputNonEmpty("Campus: ");
                        OfflineCourse of = new OfflineCourse(id, name, credits, begin, end, campus);
                        cm.addCourse(of);
                    }
                }

                case 2 -> {
                    System.out.println("*** Update course ***");
                    String id = Validate.inputNonEmpty("Course ID: ");
                    Course old = cm.findCourseById(id);
                    if (old == null) {
                        System.out.println("No data found!");
                        break;
                    }
                    System.out.println("Current: " + old);
                    System.out.println("Enter new info (press Enter to skip)");

                    System.out.print("New name: ");
                    String name = Validate.sc.nextLine().trim();
                    if (!name.isEmpty()) {
                        old.setCourseName(name);
                    }

                    System.out.print("New credits: ");
                    String cr = Validate.sc.nextLine().trim();
                    if (!cr.isEmpty()) {
                        old.setCredits(Integer.parseInt(cr));
                    }

                    System.out.println("Updated successfully.");
                }

                case 3 -> {
                    System.out.println("*** Delete course ***");
                    String id = Validate.inputNonEmpty("Course ID: ");
                    Course found = cm.findCourseById(id);
                    if (found == null) {
                        System.out.println("No data found!");
                    } else if (Validate.confirm("Are you sure to delete this course? (Y/N): ")) {
                        cm.deleteCourse(id);
                        System.out.println("Deleted successfully.");
                    }
                }

                case 4 -> {
                    System.out.println("*** Print course ***");
                    System.out.print("Do you want to print all (A), online course (O) or offline course (F): ");
                    String type = Validate.sc.nextLine().trim();
                    cm.printCourses(type);
                }

                case 5 -> {
                    System.out.println("*** Search course ***");
                    String id = Validate.inputNonEmpty("Course ID: ");
                    Course found = cm.findCourseById(id);
                    if (found == null) {
                        System.out.println("No data found!");
                    } else {
                        System.out.println(found);
                    }
                }

                case 6 ->
                    System.out.println("BYE AND SEE YOU NEXT TIME");

                default ->
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }
}
