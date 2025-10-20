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
public class FruitDAO {

    private static final String INSERT_FRUIT
            = "INSERT INTO Fruit(name, price, quantity, origin) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_FRUIT
            = "SELECT * FROM Fruit WHERE quantity > 0";
    private static final String SELECT_FRUIT_BY_ID
            = "SELECT * FROM Fruit WHERE id = ?";
    private static final String UPDATE_QUANTITY
            = "UPDATE Fruit SET quantity = ? WHERE id = ?";

    public void insert(Fruit f) {
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_FRUIT)) {
            ps.setString(1, f.getName());
            ps.setDouble(2, f.getPrice());
            ps.setInt(3, f.getQuantity());
            ps.setString(4, f.getOrigin());
            ps.executeUpdate();
            System.out.println("Fruit added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Fruit> getAll() {
        List<Fruit> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(SELECT_ALL_FRUIT)) {
            while (rs.next()) {
                list.add(new Fruit(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        rs.getString("origin")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Fruit getById(int id) {
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(SELECT_FRUIT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Fruit(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        rs.getString("origin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateQuantity(int id, int newQty) {
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(UPDATE_QUANTITY)) {
            ps.setInt(1, newQty);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void decreaseQuantity(int fruitId, int quantitySold) {
        String sql = "UPDATE Fruit SET quantity = quantity - ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, quantitySold);
            ps.setInt(2, fruitId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
