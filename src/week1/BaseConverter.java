/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week1;

public class BaseConverter {
    private int fromBase;
    private int toBase;
    private String inputValue;

    public BaseConverter(String inputValue, int fromBase, int toBase) {
        this.inputValue = inputValue;
        this.fromBase = fromBase;
        this.toBase = toBase;
    }


    public String convert() {
        int value = Integer.parseInt(inputValue, fromBase); // parse
        return Integer.toString(value, toBase).toUpperCase(); // convert
    }


    public static boolean isValid(String input, int base) {
        try {
            Integer.parseInt(input, base);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

