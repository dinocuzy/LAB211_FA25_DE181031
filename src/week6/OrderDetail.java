/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week6;

/**
 *
 * @author ASUS
 */
public class OrderDetail {

    private int id;
    private int fruitId;
    private int quantity;
    private int price;

    public OrderDetail() {
    }

    public OrderDetail(int id, int fruitId, int quantity, int price) {
        this.id = id;
        this.fruitId = fruitId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("FruitId: %d | Qty: %d | Price: %d | Amount: %d",
                fruitId, quantity, price, quantity * price);
    }
}
