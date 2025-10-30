/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week7;

/**
 *
 * @author ASUS
 */
public class Square extends TwoDimensionalShape {
    private double a;

    public Square() {
    }

    public Square(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public double calArea() {
        return a*a;
    }

    @Override
    public String getName() {
        return "Square: "+a;
    }
    
    
}
