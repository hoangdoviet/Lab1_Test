/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import Common.ConsoleColors;
import Product.Product;
import Utilities.OrderDataIO;
import Utilities.ProductDataIO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class OrderView {

    ArrayList<Order> orders;
    OrderDataIO orderDataIO;
    ArrayList<Product> products;
    ProductDataIO productDataIO;
    public static OrderView orderView = null;

    public OrderView() {
        orders = new ArrayList<Order>();
        orderDataIO = new OrderDataIO();
    }

    public static OrderView getInstance() {
        if (orderView == null) {
            orderView = new OrderView();
        }

        return orderView;
    }

    public ArrayList<Order> getOrders() {
        return orderDataIO.readData();
    }

    public void addOrder(Order order) {
        orders = orderDataIO.readData();
        orders.add(order);
        orderDataIO.writeData(orders);
    }

    public void deleteOrder(String userCode) {
        orders = orderDataIO.readData();
        orders.forEach((o) -> {
            if (o.getUserCode().equalsIgnoreCase(userCode)) {
                orders.remove(o);
            }
        });
        orderDataIO.writeData(orders);
    }

    public void updateOrder(Order orderUpdate) {
        orders = orderDataIO.readData();
        orders.forEach((o) -> {
            if (o.getUserCode().equalsIgnoreCase(orderUpdate.getUserCode())) {
                o.setCustomerName(orderUpdate.getCustomerName());
                o.setOrderDate(orderUpdate.getOrderDate());
                o.setStatus(orderUpdate.getStatus());
                o.setProducts(orderUpdate.getProducts());
            }
        });
        orderDataIO.writeData(orders);
    }

    public void updateOrderStatus(String userCode, String status) {
        orders = orderDataIO.readData();
        orders.forEach((o) -> {
            if (o.getUserCode().equalsIgnoreCase(userCode)) {
                o.setStatus(status);
               
            }
        });
        orderDataIO.writeData(orders);
    }
    public Order getOrderbyUserCode(String UserCode){
        orders = orderDataIO.readData();
        for (Order order : orders) {
            if(order.getUserCode().equalsIgnoreCase(UserCode)) {
                return order;
            }
        }
        return null;
    }

    public Product getProductID(int id) {
        products = productDataIO.readData();
        if (products == null) {
            System.out.println(ConsoleColors.BLACK_BOLD + "null");
            return null;
        }
        for (Product o : products) {
            if (o.getProductId() == id) {
                return o;
            }
        }
        return null;
    }
}
