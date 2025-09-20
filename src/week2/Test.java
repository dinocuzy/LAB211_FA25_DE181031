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
        while (true) {
            String[] options = {
                "Normal Calculator",
                "BMI Calculator",
                "Exit"
            };
            int choice = menu("Calculator Program", options);
            switch (choice) {
                case 1 -> {
                    System.out.println("\n-----Normal Calculator-----");
                    CalculatorProgram cal = new CalculatorProgram(checkDouble("Enter number: "));
                    while (true) {
                       //
                       String op=checkOperator("Enter Operator");
                       if(op.equalsIgnoreCase("=")){
                           System.out.println("Result: "+ cal.getMemory());
                           break;
                       }
                       double num=checkDouble("Enter Number: ");
                        System.out.println("Memory: "+ cal.calculate(op, num));

                    }
                    break;
                }

                case 2 -> {
                    System.out.println("\n----- BMI Calculator -----");
                    CalculatorProgram cal = new CalculatorProgram();
                    double result = cal.calBMI(checkDouble("Enter Weight(kg): "), checkDouble("Enter Height(cm): ") / 100);
                    System.out.println("BMI Number: " + result);
                    System.out.println("BMI Status: " + cal.getBMIStatus(result));
                    break;

                }
                case 3 -> {
                    System.out.println("Exiting program...");
                    return;
                }
            }
        }
    }

}
