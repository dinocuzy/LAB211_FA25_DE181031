/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week7;

/**
 *
 * @author ASUS
 */
public class Cube extends ThreeDimensionalShape {

    private double a;

    public Cube() {
    }

    public Cube(double a) {
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
        return 6 * a * a;
    }

    @Override
    public double calVolume() {
        return a * a * a;
    }

    @Override
    public String getName() {
        return "Cube: " + a;
    }

}
