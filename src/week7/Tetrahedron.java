/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week7;

/**
 *
 * @author ASUS
 */
public class Tetrahedron extends ThreeDimensionalShape {

    private double a;

    public Tetrahedron(double a) {
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
        return Math.sqrt(3) * a * a;
    }

    @Override
    public double calVolume() {
        return (1 / 12) * Math.sqrt(2) * a * a * a;
    }

    @Override
    public String getName() {
        return "Tetrahedron: " + a;
    }

}
