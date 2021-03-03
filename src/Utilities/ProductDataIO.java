/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Product.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProductDataIO {

    public ProductDataIO() {
    }

    public ArrayList<Product> readData() {
        ArrayList<Product> products = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Product.dat"));
            products = (ArrayList<Product>) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return products;
    }

    public void writeData(ArrayList<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream("Product.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
