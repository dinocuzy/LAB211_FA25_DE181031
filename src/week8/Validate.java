/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week8;

import java.time.Year;
import java.util.Scanner;
import java.util.regex.Pattern;

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
    private static final Pattern EMAIL
            = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern DIGITS = Pattern.compile("^\\d+$");

    public static int requireBirthYear(String s) {
        if (!DIGITS.matcher(s).matches() || s.length() != 4) {
            throw new IllegalArgumentException("BirthYear must be 4 digits.");
        }
        int y = Integer.parseInt(s);
        int curr = Year.now().getValue();
        if (y < 1900 || y > curr) {
            throw new IllegalArgumentException("BirthYear must be 1900.." + curr);
        }
        return y;
    }

    public static String requirePhone(String s) {
        if (!DIGITS.matcher(s).matches() || s.length() < 10) {
            throw new IllegalArgumentException("Phone must be digits and >= 10 chars.");
        }
        return s;
    }

    public static String requireEmail(String s) {
        if (!EMAIL.matcher(s).matches()) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        return s;
    }

    public static int requireExpInYear(String s) {
        if (!DIGITS.matcher(s).matches()) {
            throw new IllegalArgumentException("ExpInYear must be number.");
        }
        int v = Integer.parseInt(s);
        if (v < 0 || v > 100) {
            throw new IllegalArgumentException("ExpInYear must be 0..100.");
        }
        return v;
    }

    public static String requireRank(String s) {
        String v = s.trim();
        if (!(v.equalsIgnoreCase("Excellence") || v.equalsIgnoreCase("Good")
                || v.equalsIgnoreCase("Fair") || v.equalsIgnoreCase("Poor"))) {
            throw new IllegalArgumentException("Rank must be one of: Excellence, Good, Fair, Poor.");
        }
        return Character.toUpperCase(v.charAt(0)) + v.substring(1).toLowerCase();
    }

    public static int requireInt(String s, String field) {
        if (!DIGITS.matcher(s).matches()) {
            throw new IllegalArgumentException(field + " must be number.");
        }
        return Integer.parseInt(s);
    }

    public static String requireNonEmpty(String s, String field) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " is required.");
        }
        return s.trim();
    }

    public static String ask(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    public static boolean askYesNo(String msg) {
        System.out.print(msg);
        String s = sc.nextLine().trim();
        return s.equalsIgnoreCase("Y");
    }

    public static int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public static String inputUntilValid(String prompt, java.util.function.Function<String, String> validator) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return validator.apply(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int menu(String title, String[] options) {
        System.out.println("\n========= " + title + " =========");
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
