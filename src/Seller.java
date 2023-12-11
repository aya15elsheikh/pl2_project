import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Seller extends Employee{
    
    public Seller(){} 
    public Seller(int sellerId, String sellerName, String password, String type){
        super(sellerId,sellerName, password, "Seller");
    }

    //setters:
    @Override
    public void setPassword(String password) {
        if(!password.matches("[a-zA-Z0-9]*")){
            System.out.println("Invalid Password! Only alphanumeric characters are allowed.");
        }else{
                super.setPassword(password);
            }
    }


    //-------------------------------------------------------------------------------
                
    //metho to list all products: 
   /*  public static ArrayList<Products> getAllProducts(){
        return Products.getAllProducts();
        }
    */

    // search for product
    public static boolean searchForProduct(String productName){
        File file = new File(productName+".txt");
        if (file.exists()){
            try
            {   create_files c= new create_files();
                String path =  "D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\"+productName+".txt";
                System.out.println(Arrays.toString(c.Read(path)));
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            } 
        }
        else {
            System.out.println("Product not found \n");
            return false;
        }
        return true;
    }

    // make new order
    public void makeNewOrder(String orderName,int orderId,int sellerId, Date orderDate ,Products product, int quantity) {
        //searchProduct(product.getName());
        boolean exi= Seller.searchForProduct(product.getName());
        if (exi != false && product.getQuantity() >= quantity) {
            Order o = new Order(orderName, orderId,sellerId, orderDate, product, quantity); 
            if(o.addOrder(o)) System.out.println("\nNew Order Added:\n" + o.toString());
            else System.out.println("couldn't make the order");   
        }
    } 

    //cancel an order
    public boolean cancelOrder(String orderName){
        return true; 
    }




}

    