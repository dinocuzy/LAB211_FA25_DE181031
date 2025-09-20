/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2;
/**
 *
 * @author ASUS
 */
public abstract class Shape {

    public Shape() {
    }

    abstract void printResult();

    abstract double getPerimeter();

    abstract double getArea();
}

class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    

    @Override
    void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    @Override
    double getPerimeter() {
        return (width+length)*2;
    }

    @Override
    double getArea() {
        return width*length;
    }

}

class Circle extends Shape{
private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    void printResult() {
        System.out.println("-----Circle-----");
        System.out.println("Radius: "+radius);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    @Override
    double getPerimeter() {
        return 2*radius*Math.PI;
    }

    @Override
    double getArea() {
        return radius*radius*Math.PI;
    }
    

}
class Triangle extends Shape{
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
    
    

    @Override
    void printResult() {
        System.out.println("-----Triangle-----");
        System.out.println("Side A: "+sideA);
        System.out.println("Side B: "+sideB);
        System.out.println("Side c: "+sideC);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        
    }

    @Override
    double getPerimeter() {
        return sideA+sideB+sideC;
    }

    @Override
    double getArea() {
        double p=getPerimeter()/2;
        return Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
    }
    
}