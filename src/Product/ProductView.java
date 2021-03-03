/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import User.User;
import User.UserView;
import Utilities.ProductDataIO;
import Utilities.UserDataIO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ProductView {
//------------------DO DUY THAI---------------------//
    ArrayList<Product> products;
    ProductDataIO productDataIO;
    public static ProductView productView = null;

    public ProductView() {
        products = new ArrayList<Product>();
        productDataIO = new ProductDataIO();
    }

    public static ProductView getInstance() {
        if (productView == null) {
            productView = new ProductView();
        }

        return productView;
    }

    public ArrayList<Product> getProducts() {
        return productDataIO.readData();
    }
    public void addProduct(Product product){
        products = productDataIO.readData();
        products.add(product);
        productDataIO.writeData(products);
    }
    
    public void deleteProduct(int id){
        products = productDataIO.readData();
            products.removeIf(p -> p.getProductId()==id);
        productDataIO.writeData(products);
    }
    public void updateProduct(Product productUpd){
        products = productDataIO.readData();
        products.forEach((u) -> {
            if (u.getProductId()==productUpd.getProductId()) {
            u.setName(productUpd.getName());
            u.setPrice(productUpd.getPrice());
            u.setQuantity(productUpd.getQuantity());
            u.setOrigin(productUpd.getOrigin());
        }});
        productDataIO.writeData(products);
    }
    //------------------DO DUY THAI---------------------//
}
