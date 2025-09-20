/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2;

/**
 *
 * @author ASUS
 */
public class CalculatorProgram {

    private double memory;

    public CalculatorProgram() {
    }

    public CalculatorProgram(double memory) {
        this.memory = memory;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public double calculate(String op, double num) {
        switch (op) {
            case "+":
                memory += num;
                break;
            case "-":
                memory -= num;
                break;
            case "*":
                memory *= num;
                break;
            case "/":
                try {
                    memory /= num;
                } catch (Exception e) {
                    System.out.println("Not divide by 0");
                }
                break;
            case "^":
                memory = Math.pow(memory, num);
                break;

            default:
                System.out.println("Invalid operator!!!");
                break;
        }
        return memory;
    }

    public enum BMIStatus {
        UNDER_STANDARD, STANDARD,
        OVERWEIGHT, FAST_SHOULDLOSEWEIGHT,
        VERYFAST_SHOULDLOSEWEIGHTIMMEDIATELY
    }

    public double calBMI(double weight, double height) {
        return weight / (height * height);
    }

    public BMIStatus getBMIStatus(double bmi) {
        if (bmi < 19) {
            return BMIStatus.UNDER_STANDARD;
        } else if (bmi < 25) {
            return BMIStatus.STANDARD;
        } else if (bmi < 30) {
            return BMIStatus.OVERWEIGHT;
        } else if (bmi < 40) {
            return BMIStatus.FAST_SHOULDLOSEWEIGHT;
        } else {
            return BMIStatus.VERYFAST_SHOULDLOSEWEIGHTIMMEDIATELY;
        }
    }

}
