import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Seller extends Employee{
    
    //public Seller(){} 
    public Seller(int sellerId, String sellerName, String password, String type){
        super("Seller", sellerName, password, sellerId);
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
                
    //method  to list all products:
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
        if (exi != false && product.getQuantity() >= quantity) {
            Order order = new Order(orderName, orderId,sellerId, orderDate, product, quantity); 
            try{
                create_files or= new create_files();
                String path= "C:\\Users\\ibgam\\Documents\\GitHub\\pl2_project\\Orders\\";
                or.Create(path,orderName);
                or.Append(path, "\n"+"Order ID:"+order.getOrderId()
                +"\t Seller ID:"+order.getSellerId()
                +"\t Order Date:"+order.getOrderDate()
                +"\t Quantity:"+product.getQuantity()
                +"\n" + order.toString());
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
    public boolean cancelOrder(String orderName){
        File orderFile= new File(orderName+".txt");
        if(!orderFile.exists())return false;
        orderFile.delete();
        return true; 
    }

}


