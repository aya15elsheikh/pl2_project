import java.io.*;
import java.util.*;

public class Seller extends Employee{
    
    //public Seller(){} 
    public Seller(int sellerId, String sellerName, String password, String type){
        super(sellerId,sellerName, password, "Seller");
    }

    //setters:
  /*  @Override
    public void setPassword(String password) {
        if(!password.matches("[a-zA-Z0-9]*")){
            System.out.println("Invalid Password! Only alphanumeric characters are allowed.");
        }else{
                super.setPassword(password);
            }
    }*/


    //-------------------------------------------------------------------------------
                

    //metho to list all products:
        public void listAllProducts(){
           create_files file= new create_files();
           String path="C:\\Users\\ibgam\\Documents\\GitHub\\pl2_project\\products\\names.txt";
           file.print_file(path);
        }

    // search for product
    public boolean searchForProduct(String productName){
        File file = new File(productName+".txt");
        if (file.exists()){
            try
            {   create_files c= new create_files();
                String path =  "C:\\Users\\ibgam\\Documents\\GitHub\\pl2_project\\products\\"+productName+".txt";
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
        String name= "Apple";
        boolean exi= searchForProduct(name);
        if (exi&& product.getQuantity()>=quantity) {
            Order order = new Order(orderName, orderId,sellerId, orderDate, product, quantity); 
            try{
                create_files or= new create_files();
                String path= "C:\\Users\\ibgam\\Documents\\GitHub\\pl2_project\\Orders\\";
                or.Create(path,orderName);
                or.Append(path+orderName+".txt",
                 "Order Name:"+order.getOrderName()
                +"\n Order ID:"+String.valueOf(order.getOrderId())
                +"\n Seller ID:"+String.valueOf(order.getSellerId())
                +"\n Order Date:"+String.valueOf(order.getOrderDate())
                +"\n" + product.toString());
                int x=product.getQuantity();
                 create_files f= new create_files();
               f.update_file(path+product.getName()+".txt", "Quantity=" +String.valueOf(x), "Quantity=" +String.valueOf(x++)); 
            }catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            
    }
           
} 

     //search Orders
     public  boolean searchOrder(String orderName){
        File file = new File(orderName+".txt");
        if (file.exists()){
              try
            {   create_files c= new create_files();
                String path =  "C:\\Users\\ibgam\\Documents\\GitHub\\pl2_project\\Orders\\"+orderName+".txt";
                System.out.println(Arrays.toString(c.Read(path)));
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            } 
          return true;
        }  
        else {
             System.out.println("Order not found \n");
            return false;
        }
        
    }

    //cancel an order
    public void cancelOrder(String orderName){
        File orderFile= new File(orderName+".txt");
        if(!orderFile.exists()) System.out.println("order is not exist");
        else{ 
           /*  create_files f= new create_files();
            int qnt= Integer.valueOf(f.Read("C:\\Users\\ibgam\\Documents\\GitHub\\pl2_project\\orders\\"+orderName+".txt", 7));
            qnt++;
            f.update_file("C:\\Users\\ibgam\\Documents\\GitHub\\pl2_project\\orders\\"+orderName+".txt", orderName, orderName);*/
            create_files canceled= new create_files();
            String path="C:\\Users\\ibgam\\Documents\\GitHub\\pl2_project\\orders\\cancledOrders\\";
            canceled.Create(path+orderName+".txt",orderName);
            canceled.Append(path+orderName+".txt",orderName);
            orderFile.delete();

        } 
    }

    public static void main(String[] args) {
        Seller seller= new Seller(1, "ahmed", "hh234", "seller");
        Date d= new Date();
        Products p= new Products("ole",24, 30, "exp", 90);
        seller.listAllProducts();
       // seller.makeNewOrder("order1", 0, 0, d, p);
       // seller.searchOrder("order1");
        seller.searchForProduct("Apple");
        //seller.makeNewOrder("order2", 1, 1, d, p);
        seller.cancelOrder("order2");
    }
}



