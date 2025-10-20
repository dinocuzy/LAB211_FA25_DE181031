/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week6;

import java.util.List;

/**
 *
 * @author ASUS
 */

public class Order {

    private int id;
    private int customerId;
    private double total;
    private String orderDate;
    private List<OrderDetail> details;

    public Order() {
    }

    public Order(int id, int customerId, double total, String orderDate, List<OrderDetail> details) {
        this.id = id;
        this.customerId = customerId;
        this.total = total;
        this.orderDate = orderDate;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerId=" + customerId
                + ", total=" + total + ", orderDate='" + orderDate + "'}";
    }
}
