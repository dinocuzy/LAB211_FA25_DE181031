/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3;

import java.util.EmptyStackException;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class Stack {

    private Node head;

    public Stack() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public void inputStack(int n) {
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            push(ran.nextInt(20));
        }
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void push(Object x) {
        head = new Node(x, head);
    }

    public Object top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.info;

    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object x = head.info;
        head = head.next;
        return x;
    }
}
