import java.util.Date;
public class Products {
    private int Id;
    private  String name;
    private  int Special_Range;
    private int quantity;
    private int price;
    private String Expiry_Date;

    Products(){

    }
    Products(int Id,String name,int price,int quantity,String Expiry_Date,int Special_Range){

        this.Id=Id;
        this.Expiry_Date=Expiry_Date;
        this.name=name;
        this.price=price;
        this.Special_Range=Special_Range;
        this.quantity=quantity;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecial_Range(int Special_Range) {
        this.Special_Range = Special_Range;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setExpiry_Date(String Expiry_Date) {
        this.Expiry_Date = Expiry_Date;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getSpecial_Range() {
        return Special_Range;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getExpiry_Date() {
        return Expiry_Date;
    }

    void display(){
        System.out.println(" name of product is:"+this.name);
        System.out.println(" Id of product is:"+this.Id);
        System.out.println(" price of product is:"+this.price);
        System.out.println(" quantity of product is:"+this.quantity);
        System.out.println(" special range of product"+this.Special_Range);
        System.out.println(" Expiry date of product is:"+this.Expiry_Date);
    }
}