/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4;

import java.time.Year;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validate {

    static Scanner sc = new Scanner(System.in);

    public static int checkNum(String ms) {
        System.out.println(ms);
        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num < 1) {
                    System.out.println("Re-" + ms);
                    continue;
                }
                return num;
            } catch (Exception e) {
                System.out.println("Re-" + ms);
            }

        }

    }

    public static double checkDouble(String message) {
        while (true) {
            System.out.println(message);
            String input = sc.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (Exception e) {
                System.out.println("Please enter a number!");
            }
        }
    }

    public static String isValidID(String ms) {
        while (true) {
            System.out.print(ms);
            String id = sc.nextLine().trim();
            if (id.matches("^[0-9]{6}$")) {
                return id;
            } else {
                System.out.println("Data of id input is invalid!!!");
            }
        }
    }

    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return name.matches("^[a-zA-Z\\p{L}\\s]+$");
    }

    public static String inputName(String ms) {
        while (true) {
            System.out.print(ms);
            String name = sc.nextLine();
            if (isValidName(name.trim())) {
                return name;
            } else {
                System.out.println("Data of name input is invalid!!!");
            }
        }
    }

    public static String isPhone(String ms) {
        while (true) {
            System.out.print(ms);
            String phone = sc.nextLine().trim();
            if (phone != null && phone.matches("\\d{10}")) {
                return phone;
            } else {
                System.out.println("Data of phone input is invalid!!!");
            }
        }
    }

    public static int isYOB(String ms) {
        while (true) {
            System.out.print(ms);
            try {
                int yob = Integer.parseInt(sc.nextLine().trim());
                if (yob >= Year.now().getValue()) {
                    throw new Exception();
                }
                return yob;
            } catch (Exception e) {
                System.out.println("Data of year of birth is invalid!!!");
            }
        }
    }

    public static String isMajor(String ms) {
        while (true) {
            System.out.print(ms);
            String major = sc.nextLine().trim();

            if (!major.isEmpty() && major.length() <= 30) {
                return major;
            } else {
                System.out.println("Data of Major is invalid!!!");
            }
        }
    }

    public static int isYears(String ms, int yob) {
        int currentYear = Year.now().getValue();
        int age = currentYear - yob;
        while (true) {
            System.out.print(ms);
            try {
                int years = Integer.parseInt(sc.nextLine().trim());
                if (years == 0 && years>= age) {
                    throw new Exception();
                }
                return years;
            } catch (Exception e) {
                System.out.println("Data input is invalid!!!");
            }
        }
    }

    public static String isContractType(String ms) {
        while (true) {
            System.out.print(ms);
            String type = sc.nextLine().trim().toLowerCase();
            if (type.equals("long") || type.equals("short")) {
                return type;
            }
            System.out.println("Invalid Contract Type! Only 'Long' or 'Short'.");
        }
    }

    public static double isSalaryCoefficient(String ms) {
        while (true) {
            try {
                System.out.print(ms);
                double coef = Double.parseDouble(sc.nextLine().trim());
                if (coef >= 0) {
                    return coef;
                }
            } catch (Exception e) {
            }
            System.out.println("Invalid Salary Coefficient! Must be >= 0.");
        }
    }

    public static double isEntranceEnglishScore(String ms) {
        while (true) {
            try {
                System.out.print(ms + " (0 - 100): ");
                double score = Double.parseDouble(sc.nextLine().trim());
                if (score >= 0 && score <= 100) {
                    return score;
                }
            } catch (Exception ignored) {
            }
            System.out.println("Invalid Entrance English Score! Must be 0 to 100.");
        }
    }

    public static int menu(String title, String[] options) {
        System.out.println("\n" + title);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Your choice: ");

        while (true) {
            String input = sc.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= options.length) {
                    return choice;
                } else {
                    System.out.print("Invalid choice! Please enter 1-" + options.length + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number: ");
            }
        }
    }

}
