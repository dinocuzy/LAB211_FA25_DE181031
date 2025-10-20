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

    private static final String INSERT_ORDER_HEADER
            = "INSERT INTO OrderHeader(customerId, total) VALUES (?, ?)";
    private static final String INSERT_ORDER_DETAIL
            = "INSERT INTO OrderDetail(orderId, fruitId, quantity, price) VALUES (?, ?, ?, ?)";
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

            PreparedStatement ps = con.prepareStatement(INSERT_ORDER_HEADER, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customerId);
            ps.setDouble(2, total);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int orderId = -1;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            PreparedStatement ps2 = con.prepareStatement(INSERT_ORDER_DETAIL);
            FruitDAO fruitDAO = new FruitDAO();
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
