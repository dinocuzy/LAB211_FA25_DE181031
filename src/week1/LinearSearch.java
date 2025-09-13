package week1;

import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */
public class LinearSearch {

    private int[] arr;

    public LinearSearch(int n) {
        arr = new int[n];
    }

    public LinearSearch(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void createArr(int n) {
        Random ran = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(n);
        }
    }

    public void showArr() {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public int findIndex(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    
}
