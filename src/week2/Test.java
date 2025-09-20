/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2;

import static week2.Validate.*;

/**
 *
 * @author ASUS
 */
public class Test {

    public static void main(String[] args) {
//        System.out.println("=====Calculator Shape Program=====");
//        Rectangle rectangle = new Rectangle(checkDouble("Please input side width of Rectangle:"), checkDouble("Please input length of Rectangle:"));
//        Circle circle = new Circle(checkDouble("Please input radius of Circle: "));
//        Triangle triangle = checkTriangle();
//        rectangle.printResult();
//        circle.printResult();
//        triangle.printResult();
//        while (true) {
//            String[] options = {
//                "Normal Calculator",
//                "BMI Calculator",
//                "Exit"
//            };
//            int choice = menu("Calculator Program", options);
//            switch (choice) {
//                case 1 -> {
//                    System.out.println("\n-----Normal Calculator-----");
//                    CalculatorProgram cal = new CalculatorProgram(checkDouble("Enter number: "));
//                    while (true) {
//                       //
//                       String op=checkOperator("Enter Operator");
//                       if(op.equalsIgnoreCase("=")){
//                           System.out.println("Result: "+ cal.getMemory());
//                           break;
//                       }
//                       double num=checkDouble("Enter Number: ");
//                        System.out.println("Memory: "+ cal.calculate(op, num));
//
//                    }
//                    break;
//                }
//
//                case 2 -> {
//                    System.out.println("\n----- BMI Calculator -----");
//                    CalculatorProgram cal = new CalculatorProgram();
//                    double result = cal.calBMI(checkDouble("Enter Weight(kg): "), checkDouble("Enter Height(cm): ") / 100);
//                    System.out.println("BMI Number: " + result);
//                    System.out.println("BMI Status: " + cal.getBMIStatus(result));
//                    break;
//
//                }
//                case 3 -> {
//                    System.out.println("Exiting program...");
//                    return;
//                }
//            }
//        }

        String[] options = {
            "1. Addition Matrix",
            "2. Subtraction Matrix",
            "3. Multiplication Matrix",
            "4. Quit"
        };
        while (true) {
            int choice = menu("Calculator Program", options);
            switch (choice) {
                case 1 -> {
                    System.out.println("-------- Addition --------");
                    Matrix matrix1 = inputMatrix(checkNum("Enter Row Matrix 1: "), checkNum("Enter Column Matrix 1: "));
                    int rows = checkNum("Enter Row Matrix 2: ");
                    int cols = checkNum("Enter Column Matrix 2: ");
                    while (matrix1.getCols() != rows) {
                        System.out.println("Number of rows and columns of 2 matrix must be the same!!!");
                        rows = checkNum("Enter Row Matrix 2: ");
                        cols = checkNum("Enter Column Matrix 2: ");
                    }
                    Matrix matrix2 = inputMatrix(rows, cols);
                    System.out.println("-------- Result --------");
                    matrix1.print();
                    System.out.println("+");
                    matrix2.print();
                    System.out.println("=");
                    matrix1.add(matrix2).print();
                    break;
                }
                case 2 -> {
                    System.out.println("-------- Subtraction --------");
                    Matrix matrix1 = inputMatrix(checkNum("Enter Row Matrix 1: "), checkNum("Enter Column Matrix 1: "));
                    int rows = checkNum("Enter Row Matrix 2: ");
                    int cols = checkNum("Enter Column Matrix 2: ");
                    while (matrix1.getCols() != rows) {
                        System.out.println("Number of rows and columns of 2 matrix must be the same!!!");
                        rows = checkNum("Enter Row Matrix 2: ");
                        cols = checkNum("Enter Column Matrix 2: ");
                    }
                    Matrix matrix2 = inputMatrix(rows, cols);
                    System.out.println("-------- Result --------");
                    matrix1.print();
                    System.out.println("-");
                    matrix2.print();
                    System.out.println("=");
                    matrix1.subtract(matrix2).print();
                    break;
                }
                case 3 -> {
                    System.out.println("-------- Multiplication --------");
                    Matrix matrix1 = inputMatrix(checkNum("Enter Row Matrix 1: "), checkNum("Enter Column Matrix 1: "));
                    int rows = checkNum("Enter Row Matrix 2: ");
                    int cols = checkNum("Enter Column Matrix 2: ");
                    while (matrix1.getCols() != rows) {
                        System.out.println("Number rows of matrix 1 must be the same with number column of matrix 2!!!");
                        rows = checkNum("Enter Row Matrix 2: ");
                        cols = checkNum("Enter Column Matrix 2: ");
                    }
                    Matrix matrix2 = inputMatrix(rows, cols);

                    System.out.println("-------- Result --------");
                    matrix1.print();
                    System.out.println("*");
                    matrix2.print();
                    System.out.println("=");
                    matrix1.multiply(matrix2).print();
                    break;
                }
                case 4 -> {
                    System.out.println("Exiting program...");
                    return;
                }
            }
        }
    }
}
