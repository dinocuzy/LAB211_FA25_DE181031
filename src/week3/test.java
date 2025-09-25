/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3;

import static week3.Validate.*;

/**
 *
 * @author ASUS
 */
public class test {

    public static void main(String[] args) {
        Sort s = new Sort();
        String[] options = {"Bubble Sort", "Quick Sort", "Binary Search", "Stack Test", "Quit"};
        while (true) {
            int choice = menu("Sort and Search Array System", options);
            switch (choice) {
                case 1:
                    System.out.println("-------- Bubble Sort --------");
                    s = new Sort(checkNum("Enter size of array: "));
                    s.inputArr(50);
                    s.printArr("Unsorted array: ");
                    s.sortByBubbleSort();
                    s.printArr("Sorted array:");
                    break;
                case 2:
                    System.out.println("-------- Quick Sort --------");
                    s = new Sort(checkNum("Enter size of array: "));
                    s.inputArr(50);
                    s.printArr("Unsorted array: ");
                    s.sortByQuickSort();
                    s.printArr("Sorted array:");
                    break;
                case 3:
                    System.out.println("-------- Binary Search --------");
                    s = new Sort(checkNum("Enter size of array: "));
                    s.inputArr(10);
                    int value = checkNum("Enter value need to search: ");
                    int result = s.searchByBinary(value);
                    s.printArr("Sorted array:");
                    if (result != -1) {
                        System.out.println("Found " + value + " at " + result);
                    } else {
                        System.out.println("Not found " + value);
                    }
                    break;
                case 4:
                    System.out.println("-------- Stack Test --------");
                    Stack stack = new Stack();
                    stack.inputStack(checkNum("Enter number elements of stack: "));
                    String[] op = {"Push", "Top", "Pop", "Quit"};
                    boolean back = false;
                    while (!back) {
                        int c = menu("Stack Menu", op);
                        switch (c) {
                            case 1:
                                stack.traverse();
                                stack.push(checkNum("Input number to push: "));
                                stack.traverse();
                                break;
                            case 2:
                                stack.traverse();
                                stack.top();
                                break;
                            case 3:
                                stack.traverse();
                                stack.pop();
                                stack.traverse();
                                break;
                            case 4:
                                back = true;
                                break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Thank you !!!");
                    return;
            }
        }

    }

}
