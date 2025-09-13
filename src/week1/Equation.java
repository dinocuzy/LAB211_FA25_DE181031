/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week1;

/**
 *
 * @author ASUS
 */

public class Equation {
    private double a, b, c; 
    private int type; 

    public Equation(double a, double b) {
        this.a = a;
        this.b = b;
        this.type = 1;
    }

    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.type = 2;
    }

    public void solve() {
        if (type == 1) {
            System.out.println("=== Linear Equation (Ax + B = 0) ===");
            if (a == 0) {
                if (b == 0) System.out.println("Infinite solutions.");
                else System.out.println("No solution.");
            } else {
                System.out.println("Solution: x = " + (-b / a));
            }
            displayProperties(new double[]{a, b});
        } else {
            System.out.println("=== Quadratic Equation (Ax^2 + Bx + C = 0) ===");
            if (a == 0) {
                new Equation(b, c).solve(); 
                return;
            }
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("No real solution.");
            } else if (delta == 0) {
                System.out.println("Double root: x = " + (-b / (2 * a)));
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("x1 = " + x1 + ", x2 = " + x2);
            }
            displayProperties(new double[]{a, b, c});
        }
    }

    private void displayProperties(double[] coeffs) {
        System.out.print("Coefficients: ");
        for (double c : coeffs) System.out.print(c + " ");
        System.out.println();

        System.out.print("Even: ");
        for (double c : coeffs) if ((int) c % 2 == 0) System.out.print((int) c + " ");
        System.out.println();

        System.out.print("Odd: ");
        for (double c : coeffs) if ((int) c % 2 != 0) System.out.print((int) c + " ");
        System.out.println();

        System.out.print("Perfect squares: ");
        for (double c : coeffs) {
            int n = (int) c;
            if (n >= 0 && Math.sqrt(n) == (int) Math.sqrt(n)) {
                System.out.print(n + " ");
            }
        }
        System.out.println("\n");
    }
}
