import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Seller extends Employee{
    
    private Object order;
    //public Seller(){} 
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
     public static void listAllProducts(){
        // list all files in products file: 
        File folder = new File("products.txt");
        File[] listOfFiles = folder.listFiles();
        int counter=1;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(listOfFiles[i]));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.printf("%3d %s\n",counter++,line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    

    // search for product
    public static boolean searchForProduct(String productName){
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
        boolean exi= Seller.searchForProduct(product.getName());
        if (exi && product.getQuantity() >= quantity) {
            Order order = new Order(orderName, orderId,sellerId, orderDate, product, quantity); 
            try{
                create_files or= new create_files();
                String path= "C:\\Users\\ibgam\\Documents\\GitHub\\pl2_project\\Orders\\";
                or.Create(path,orderName);
                or.Append(path, "\n"+"Order ID:"+String.valueOf(order.getOrderId())
                +"\t Seller ID:"+String.valueOf(order.getSellerId())
                +"\t Order Date:"+String.valueOf(order.getOrderDate())
                +"\t Quantity:"+String.valueOf(product.getQuantity())
                +"\n" + order.toString());
                int x=product.getQuantity();
                product.setQuantity(x++);
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
    public void cancelOrder(Order order){
        File orderFile= new File(order.getOrderName()+".txt");
        if(!orderFile.exists()) System.out.println("order is not exist");
        else{ 
            create_files canceled= new create_files();
            String path="C:\\Users\\ibgam\\Documents\\GitHub\\pl2_project\\orders\\cancledOrders\\";
            canceled.Create(path, order.getOrderName());
            canceled.Append(path, order.toString());
            orderFile.delete();
            int x=order.getProducts().getQuantity();
            order.getProducts().setQuantity(x++);
        } 
    }
}




