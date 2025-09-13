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
public class Test {
//    public static void main(String[] args) {
//
//        LinearSearch linearSearch = new LinearSearch(Validate.checkNum("Enter size:"));
//
//        linearSearch.createArr(Validate.checkNum("Enter scope:"));
//
//        linearSearch.showArr();
//        int num = Validate.checkNum("Enter number need to search");
//        int rs = linearSearch.findIndex(num);
//        if (rs >= 0) {
//            System.out.println("Found " + num + " at index: " + rs);
//        } else {
//            System.out.println("Not found: " + num);
//        }
//
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your content: ");
//        String input = sc.nextLine();
//        LetterAndCharacterCount letterAndCharacterCount=new LetterAndCharacterCount(input);
//        System.out.println(letterAndCharacterCount.countWords().toString());
//        System.out.println(letterAndCharacterCount.countChars().toString());
//    }

//    public static void main(String[] args) {
//        while (true) {
//            String[] options = {
//                "Linear Equation (Ax + B = 0)",
//                "Quadratic Equation (Ax^2 + Bx + C = 0)",
//                "Exit"
//            };
//
//            int choice = Validate.menu("Equation Program", options);
//
//            switch (choice) {
//                case 1 -> {
//                    System.out.println("\n----- Calculate Equation -----");
//                    double a = Validate.checkDouble("Enter A: ");
//                    double b = Validate.checkDouble("Enter B: ");
//                    Equation eq = new Equation(a, b);
//                    eq.solve();
//                }
//                case 2 -> {
//                    System.out.println("\n----- Calculate Quadratic Equation -----");
//                    double a = Validate.checkDouble("Enter A: ");
//                    double b = Validate.checkDouble("Enter B: ");
//                    double c = Validate.checkDouble("Enter C: ");
//                    Equation eq = new Equation(a, b, c);
//                    eq.solve();
//                }
//                case 3 -> {
//                    System.out.println("Exiting program...");
//                    return;
//                }
//            }
//        }
//    }
    public static void main(String[] args) {
        String[] baseOptions = {
            "Binary (base 2)",
            "Decimal (base 10)",
            "Hexadecimal (base 16)",
            "Exit"
        };

        while (true) {
            int inChoice = Validate.menu("Select Input Base", baseOptions);
            if (inChoice == 4) {
                System.out.println("Exiting program...");
                break;
            }

            int outChoice = Validate.menu("Select Output Base", baseOptions);
            if (outChoice == 4) {
                System.out.println("Exiting program...");
                break;
            }

            int fromBase = (inChoice == 1 ? 2 : inChoice == 2 ? 10 : 16);
            int toBase = (outChoice == 1 ? 2 : outChoice == 2 ? 10 : 16);

            String input;
            while (true) {
                System.out.print("Enter number in base " + fromBase + ": ");
                input = Validate.sc.nextLine().trim();

                if (BaseConverter.isValid(input, fromBase)) {
                    break;
                } else {
                    System.out.println("Invalid number for base " + fromBase + ". Please try again!");
                }
            }

            BaseConverter converter = new BaseConverter(input, fromBase, toBase);
            String result = converter.convert();

            System.out.println(" Result in base " + toBase + ": " + result);
        }
    }
}
