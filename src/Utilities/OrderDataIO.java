/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Order.Order;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDataIO {

    public OrderDataIO() {
    }

    public ArrayList<Order> readData() {
        try {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("order.dat"))) {
                return (ArrayList<Order>) in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeData(ArrayList<Order> orders) {
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("order.dat"))) {
                oos.writeObject(orders);
            }
            System.out.println("WRITE DATA SUCCESSFULLy");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
