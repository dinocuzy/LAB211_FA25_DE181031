/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week7;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.###");
        ArrayList<Shape> shapes = new ArrayList<>();

        String[] options = {
            "Add Circle",
            "Add Square",
            "Add Triangle",
            "Add Sphere",
            "Add Cube",
            "Add Tetrahedron",
            "Show all shapes",
            "Exit"
        };

        int choice;
        do {
            choice = Validate.menu("SHAPE MENU", options);
            switch (choice) {
                case 1 -> {
                    double r = Validate.checkDouble("Enter radius: ");
                    shapes.add(new Circle(r));
                    System.out.println("Circle added!");
                }
                case 2 -> {
                    double a = Validate.checkDouble("Enter side: ");
                    shapes.add(new Square(a));
                    System.out.println("Square added!");
                }
                case 3 -> {
                    Triangle triangle = Validate.checkTriangle();
                    shapes.add(triangle);
                    System.out.println("Triangle added!");
                }
                case 4 -> {
                    double r = Validate.checkDouble("Enter radius: ");
                    shapes.add(new Sphere(r));
                    System.out.println("Sphere added!");
                }
                case 5 -> {
                    double a = Validate.checkDouble("Enter side: ");
                    shapes.add(new Cube(a));
                    System.out.println("Cube added!");
                }
                case 6 -> {
                    double a = Validate.checkDouble("Enter edge: ");
                    shapes.add(new Tetrahedron(a));
                    System.out.println("Tetrahedron added!");
                }
                case 7 -> {
                    if (shapes.isEmpty()) {
                        System.out.println(" No shapes to display!");
                    } else {
                        System.out.println("\n--- SHAPE LIST ---");
                        for (Shape s : shapes) {
                            printShapeInfo(s, df);
                        }
                    }
                }
                case 8 ->
                    System.out.println("Exiting program...");
            }
        } while (choice != 6);
    }

    private static void printShapeInfo(Shape s, DecimalFormat df) {
        System.out.println("\n" + s.getName());
        if (s instanceof TwoDimensionalShape td) {
            System.out.println("  Type: 2D");
            System.out.println("  Area = " + df.format(td.calArea()));
        } else if (s instanceof ThreeDimensionalShape thd) {
            System.out.println("  Type: 3D");
            System.out.println("  Surface Area = " + df.format(thd.calArea()));
            System.out.println("  Volume       = " + df.format(thd.calVolume()));
        }
    }
}
