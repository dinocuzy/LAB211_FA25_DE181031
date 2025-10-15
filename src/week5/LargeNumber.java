/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5;

/**
 *
 * @author ASUS
 */
public class LargeNumber {

    private String num;

    public LargeNumber() {
    }

    public LargeNumber(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return num;
    }

    public String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        boolean isFirstZero = true;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0 && isFirstZero) {
                continue;
            }
            isFirstZero = false;
            sb.append(arr[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public int[] toArray() {
        int[] arr = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(num.length() - 1 - i) - '0';
        }
        return arr;
    }

    public LargeNumber add(LargeNumber other) {
        int a[] = this.toArray();
        int b[] = other.toArray();
        int[] result = new int[Math.max(a.length, b.length) + 1];
        int carry = 0;
        for (int i = 0; i < result.length - 1; i++) {
            int sum = carry;
            if (i < a.length) {
                sum += a[i];
            }
            if (i < b.length) {
                sum += b[i];
            }
            result[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            result[result.length - 1] = carry;
        }
        return new LargeNumber(arrayToString(result));
    }

    public LargeNumber multiply(LargeNumber other) {
        int a[] = this.toArray();
        int b[] = other.toArray();
        int[] result = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            int carry = 0;
            for (int j = 0; j < b.length; j++) {
                int mul = result[i + j] + a[i] * b[j] + carry;
                result[i + j] = mul % 10;
                carry = mul / 10;
            }
            if (carry > 0) {
                result[i + b.length] = carry;
            }
        }
        return new LargeNumber(arrayToString(result));
    }

}
