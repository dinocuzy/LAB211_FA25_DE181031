/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week6;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class FruitShopApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FruitDAO fruitDAO = new FruitDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        OrderDAO orderDAO = new OrderDAO();
        String[] Options = {"Create Fruit", "View Orders", "Shopping", "Exit"};
        int choice;
        do {
            choice = Validate.menu("FRUIT SHOP SYSTEM", Options);

            switch (choice) {
                case 1 -> {
                    System.out.print("Fruit name: ");
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    int price = sc.nextInt();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Origin: ");
                    String origin = sc.nextLine();

                    fruitDAO.insert(new Fruit(0, name, price, qty, origin));
                }
                case 2 ->
                    orderDAO.viewOrders();

                case 3 -> {
                    List<Fruit> fruits = fruitDAO.getAll();
                    if (fruits.isEmpty()) {
                        System.out.println("No fruits available!");
                        break;
                    }

                    List<OrderDetail> cart = new ArrayList<>();
                    while (true) {
                        System.out.printf("\n|%-5s|%-10s|%-10s|%-10s|%-10s|\n", "Item", "Name", "Origin", " Price", " Qty");
                        int index = 1;
                        for (Fruit f : fruits) {
                            System.out.println(f.toString());
                        }
                        System.out.print("Select item number: ");
                        int sel = sc.nextInt();
                        sc.nextLine();

                        Fruit chosen = fruits.get(sel - 1);
                        System.out.print("Quantity: ");
                        int q = sc.nextInt();
                        sc.nextLine();

                        if (q > chosen.getQuantity()) {
                            System.out.println("Not enough stock!");
                            continue;
                        }

                        cart.add(new OrderDetail(0, chosen.getId(), q, chosen.getPrice()));
                        fruitDAO.updateQuantity(chosen.getId(), chosen.getQuantity() - q);

                        System.out.print("Continue shopping (Y/N)? ");
                        if (sc.nextLine().equalsIgnoreCase("N")) {
                            break;
                        }
                    }

                    double total = cart.stream().mapToDouble(d -> d.getPrice() * d.getQuantity()).sum();
                    System.out.printf("Total: %.2f%n", total);

                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    int custId = customerDAO.insert(new Customer(0, name));
                    orderDAO.createOrder(custId, total, cart);
                    System.out.println("Order created successfully!");
                }

                case 4 -> {
                    System.out.println("Bye!");
                    return;
                }
            }
        } while (choice != 4);
    }
}
