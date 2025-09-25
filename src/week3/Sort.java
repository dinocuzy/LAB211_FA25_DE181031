/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class Sort {

    private int[] arr;

    public Sort() {
    }

    public Sort(int n) {
        this.arr = new int[n];
    }

    public Sort(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void printArr(String ms) {
        System.out.println(ms + Arrays.toString(arr));
    }

    public void inputArr(int n) {
        Random ran = new Random();
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = ran.nextInt(n);
        }
    }

    public void sortByBubbleSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            int check = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    check++;
                }
            }
            if (check == 0) {
                break;
            }
        }
    }

    public void sortByQuickSort() {
        quickSort(0, arr.length - 1);

    }

    private void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[(left + right) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) {
            quickSort(left, j);
        }
        if (i < right) {
            quickSort(i, right);
        }
    }

    
    
    
    
    public int searchByBinary(int value) {
        sortByBubbleSort();
        return binarySearch(0, arr.length - 1, value);
    }

    private int binarySearch(int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return binarySearch(left, mid - 1, value);
        } else{
            return binarySearch(mid + 1, right, value);
        }
    }

}
