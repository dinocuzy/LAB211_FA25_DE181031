/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week7;

/**
 *
 * @author ASUS
 */
public class Sphere extends ThreeDimensionalShape {

    private double r;

    public Sphere(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double calArea() {
        return 4.0 * Math.PI * r * r;
    }

    @Override
    public double calVolume() {
        return (4.0 / 3.0) * Math.PI * r * r * r;
    }

    @Override
    public String getName() {
        return "Sphere: " + r;
    }

}
