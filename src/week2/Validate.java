/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2;

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

    public static Triangle checkTriangle() {
        while (true) {
            try {
                double a = checkDouble("Please input side A of Triangle: ");
                double b = checkDouble("Please input side B of Triangle: ");
                double c = checkDouble("Please input side C of Triangle: ");
                if (b + c <= a || a + b <= c || a + c <= b) {
                    continue;
                }
                return new Triangle(a, b, c);
            } catch (Exception e) {
                System.out.println("Is not triangle!!!");
            }
        }
    }

    public static String checkOperator(String ms) {

        String allowed = "+-*/^=";
        while(true){
        try {
            System.out.println(ms);
            String op = sc.nextLine().trim();
            if (op == null || op.length() != 1 || allowed.indexOf(op.charAt(0)) == -1) {
                throw new Exception();
            }
            return op;
        } catch (Exception e) {
            System.out.println("Please input (+, -, *, /, ^)");
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
