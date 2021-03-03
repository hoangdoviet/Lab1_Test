/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import Common.ConsoleColors;
import Utilities.ProductDataIO;
import Utilities.UserDataIO;
import Utilities.Validate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProductController {
    //------------------DO DUY THAI---------------------//
    public static ProductController productController = null;
    private Product product;
    private ProductDataIO productDataIO;
    private Validate validate;
    
    public ProductController() {
        productDataIO = new ProductDataIO();
        validate = new Validate();
    }
    public static ProductController getInstance() {
        if (productController == null) {
            productController = new ProductController();
        }
        return productController;
    }
    public void menu(){
        System.out.println(ConsoleColors.BLUE_BOLD + "--------------------------------");
        System.out.println(ConsoleColors.BLUE_BOLD + "Manage Product");
        System.out.println(ConsoleColors.BLUE_BOLD + "1. View");
        System.out.println(ConsoleColors.BLUE_BOLD + "2. Add");
        System.out.println(ConsoleColors.BLUE_BOLD + "3. Update");
        System.out.println(ConsoleColors.BLUE_BOLD + "4. Delete");
        System.out.println(ConsoleColors.BLUE_BOLD + "5. Back");
        System.out.println(ConsoleColors.BLUE_BOLD + "--------------------------------");
    }
    
    public void displayProduct(ArrayList<Product> list){
        System.out.println("----------------------------------------------------------------------------");
        System.out.format("|%10s|%20s|%10s|%10s|%20s|\n", "id","name","price","quantity","origin");
        for(Product p : list){
            System.out.format("|%10s|%20s|%10.2f|%10d|%20s|\n", p.getProductId(),p.getName(),p.getPrice(),p.getQuantity(),p.getOrigin());
        }
        System.out.println("----------------------------------------------------------------------------");
    }
    
    public void add(){
        try {
            String name = (new Validate()).getString("Name: ");
            Double price = (new Validate()).getDOUBLE("Price: ");
            int quantity = (new Validate()).getINT("Quantity: ");
            String origin = (new Validate()).getString("Origin: ");
            (new ProductView()).addProduct(new Product((new ProductView()).getProducts().size()+1, name, price, quantity, origin));
            System.out.println("Successful!!!\n");
        } catch (IOException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(){
        try {
            int id = (new Validate()).getINT("id: ");
            (new ProductView()).deleteProduct(id);
            System.out.println("Successful!!!\n");
        } catch (IOException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(){
        try {
            int id = (new Validate()).getINT("id: ");
            String name = (new Validate()).getString("Name: ");
            Double price = (new Validate()).getDOUBLE("Price: ");
            int quantity = (new Validate()).getINT("Quantity: ");
            String origin = (new Validate()).getString("Origin: ");
            (new ProductView()).updateProduct(new Product(id, name, price, quantity, origin));
            System.out.println("Successful!!!\n");
        } catch (IOException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void viewProduct(){

        int choice = -1;
        while (true) {
            try {
                menu();
                choice = validate.getINT_LIMIT("Your choice: ", 1, 5);
                switch (choice) {
                    case 1:
                        displayProduct((new ProductView()).getProducts());
                        break;
                    case 2:
                        add();
                        break;
                    case 3:
                        update();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        return;
                }
            } catch (IOException ex) {
            }
        }
    }
    //------------------DO DUY THAI---------------------//
}
