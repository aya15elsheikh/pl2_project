import java.util.*;

public class Order {
   private String orderName;
   private int orderId;
   private int sellerId;
   private Date orderDate;
   private Products product;
   private int quantity;

    public Order(String orderName,int orderId, int sellerId, Date orderDate, Products product, int quantity) {
       this.orderName=orderName;
       this.orderId = orderId;
       this.sellerId = sellerId;
       this.orderDate = orderDate;
       this.product = product;
       this.quantity = quantity;
   }


    //setters:
    public void setOrderId(int id){this.orderId=id;}
    public void setSellerId(int sid){this.sellerId=sid;}
    public void setProduct(Products prod){this.product=prod;}
    public void setQuantity(int qty){this.quantity=qty;}
    //getters:
    public int getOrderId(){return this.orderId;}
    public int getSellerId() { return this.sellerId; }
    public Date getOrderDate() { return new Date(this.orderDate.getTime());}  // Return a clone of the internal date
    public Products geProducts(){return this.product;}

    @Override
    public String toString() {
        return "Order{" +
        "orderId=" + orderId +
        ", sellerId=" + sellerId +
        ", orderDate=" + orderDate +
        ", product=" + product +
        ", quantity=" + quantity + '}';
    }

   // -----------------------------------------------------------


   //add order:
    public boolean addOrder(Order order){
        try{
            create_files or= new create_files();
            String path= "C:\\Users\\ibgam\\Documents\\GitHub\\pl2_project\\Orders\\";
            or.Create(path,orderName);
            or.Append(path, "\n"+"Order ID:"+order.getOrderId()
            +"\t Seller ID:"+order.getSellerId()
            +"\t Order Date:"+order.getOrderDate()
            +"\t Quantity:"+product.getQuantity()
            +"\n" + order.toString());
            return true;
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
    }

    
            
}


