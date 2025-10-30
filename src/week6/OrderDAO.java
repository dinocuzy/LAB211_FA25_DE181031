/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week6;

import java.sql.*;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class OrderDAO {

    private static final String INSERT_ORDER
            = "INSERT INTO OrderHeader(customerId, total) VALUES (?, ?)";
    private static final String INSERT_ORDER_DETAIL
            = "INSERT INTO OrderDetail(orderId, fruitId, quantity, price) VALUES (?, ?, ?, ?)";
    private static final String SELECT_LATEST_ORDER_BY_CUSTOMER
            = "SELECT TOP 1 id, total FROM OrderHeader WHERE customerId = ? ORDER BY id DESC";
    private static final String SELECT_DETAIL_BY_ORDER_AND_FRUIT
            = "SELECT quantity FROM OrderDetail WHERE orderId = ? AND fruitId = ?";
    private static final String UPDATE_DETAIL_INCREMENT_QTY
            = "UPDATE OrderDetail SET quantity = quantity + ? WHERE orderId = ? AND fruitId = ?";
    private static final String INCREMENT_ORDER_TOTAL
            = "UPDATE OrderHeader SET total = total + ? WHERE id = ?";
    private static final String SELECT_ALL_ORDERS
            = """
        SELECT c.name AS customer, f.name AS fruit, d.quantity, d.price,
               (d.quantity*d.price) AS amount, h.total
        FROM OrderHeader h
        JOIN Customer c ON h.customerId = c.id
        JOIN OrderDetail d ON h.id = d.orderId
        JOIN Fruit f ON f.id = d.fruitId
        ORDER BY h.id, c.name
        """;

    public int createOrder(int customerId, double total, List<OrderDetail> details) {
        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            // Try to find the latest existing order for this customer to merge into
            Integer existingOrderId = null;
            try (PreparedStatement findOrder = con.prepareStatement(SELECT_LATEST_ORDER_BY_CUSTOMER)) {
                findOrder.setInt(1, customerId);
                try (ResultSet rs = findOrder.executeQuery()) {
                    if (rs.next()) {
                        existingOrderId = rs.getInt("id");
                    }
                }
            }

            FruitDAO fruitDAO = new FruitDAO();

            if (existingOrderId != null) {
                double addedTotal = 0;
                try (PreparedStatement selDetail = con.prepareStatement(SELECT_DETAIL_BY_ORDER_AND_FRUIT);
                     PreparedStatement updDetail = con.prepareStatement(UPDATE_DETAIL_INCREMENT_QTY);
                     PreparedStatement insDetail = con.prepareStatement(INSERT_ORDER_DETAIL);
                     PreparedStatement updTotal = con.prepareStatement(INCREMENT_ORDER_TOTAL)) {

                    for (OrderDetail d : details) {
                        addedTotal += d.getQuantity() * d.getPrice();

                        // Upsert detail: if exists -> increment, else insert
                        selDetail.setInt(1, existingOrderId);
                        selDetail.setInt(2, d.getFruitId());
                        try (ResultSet rs = selDetail.executeQuery()) {
                            if (rs.next()) {
                                updDetail.setInt(1, d.getQuantity());
                                updDetail.setInt(2, existingOrderId);
                                updDetail.setInt(3, d.getFruitId());
                                updDetail.executeUpdate();
                            } else {
                                insDetail.setInt(1, existingOrderId);
                                insDetail.setInt(2, d.getFruitId());
                                insDetail.setInt(3, d.getQuantity());
                                insDetail.setDouble(4, d.getPrice());
                                insDetail.executeUpdate();
                            }
                        }

                        // Decrease stock by newly added quantity
                        fruitDAO.decreaseQuantity(d.getFruitId(), d.getQuantity());
                    }

                    // Increment order total by added amount
                    updTotal.setDouble(1, addedTotal);
                    updTotal.setInt(2, existingOrderId);
                    updTotal.executeUpdate();
                }

                con.commit();
                return existingOrderId;
            } else {
                // No existing order, create a new order as usual
                PreparedStatement ps = con.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, customerId);
                ps.setDouble(2, total);
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                int orderId = -1;
                if (rs.next()) {
                    orderId = rs.getInt(1);
                }

                PreparedStatement ps2 = con.prepareStatement(INSERT_ORDER_DETAIL);
                for (OrderDetail d : details) {
                    ps2.setInt(1, orderId);
                    ps2.setInt(2, d.getFruitId());
                    ps2.setInt(3, d.getQuantity());
                    ps2.setDouble(4, d.getPrice());
                    ps2.addBatch();
                    fruitDAO.decreaseQuantity(d.getFruitId(), d.getQuantity());
                }
                ps2.executeBatch();

                con.commit();
                return orderId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void viewOrders() {
        try (Connection con = DBConnection.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(SELECT_ALL_ORDERS)) {

            String currentCustomer = "";
            while (rs.next()) {
                String cust = rs.getString("customer");
                if (!cust.equals(currentCustomer)) {
                    currentCustomer = cust;
                    System.out.println("\nCustomer: " + cust);
                    System.out.println("Product\tQty\tPrice\tAmount");
                }
                System.out.printf("%s\t%d\t%d$\t%d$%n",
                        rs.getString("fruit"),
                        rs.getInt("quantity"),
                        rs.getInt("price"),
                        rs.getInt("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
