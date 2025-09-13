/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week1;

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
            System.out.print(message);
            String input = sc.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
    }

    public static int menu(String title, String[] options) {
        System.out.println("\n========= " + title + " =========");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print(">> Your choice: ");

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
