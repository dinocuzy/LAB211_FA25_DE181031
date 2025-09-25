/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3;

/**
 *
 * @author ASUS
 */
public class Node {

    Object info;
    Node next;

    public Node(Object info) {
        this.info = info;
    }

    public Node(Object info, Node next) {
        this.info = info;
        this.next = next;
    }

}
