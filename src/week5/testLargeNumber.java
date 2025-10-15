/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class testLargeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Menu\n1.Add\n2.Multiply\n3.Quit");
            System.out.println("Your operator:");
            int op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1:
                    System.out.println("Enter number 1: ");
                    LargeNumber num1 = new LargeNumber(sc.nextLine());
                    System.out.println("Enter number 2: ");
                    LargeNumber num2 = new LargeNumber(sc.nextLine());
                    System.out.println(num1.toString() + " + " + num2.toString() + " = ");
                    System.out.print(num1.add(num2).toString());
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Enter number 1: ");
                    num1 = new LargeNumber(sc.nextLine());
                    System.out.println("Enter number 2: ");
                    num2 = new LargeNumber(sc.nextLine());
                    System.out.println(num1.toString() + " * " + num2.toString() + " = ");
                    System.out.print(num1.multiply(num2).toString());
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Thank you");
                    return;
                default:
                    System.out.println("Your choice not support!!!");
                    break;
            }
        }
    }

}
