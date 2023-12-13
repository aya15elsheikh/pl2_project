public class Products {
    private static int Id=1;
    private  String name;
    private  int Special_Range;
    private int quantity;
    private int price;
    private String Expiry_Date;
    private int Damaged_quantity;

    Products(){
       this.Id++;
    }
    Products(String name,int price,int quantity,String Expiry_Date,int Special_Range){

        this.Id++;
        this.Expiry_Date=Expiry_Date;
        this.name=name;
        this.price=price;
        this.Special_Range=Special_Range;
        this.quantity=quantity;
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
    public void setDamaged_quantity(int Damaged_quantity) {
        this.Damaged_quantity = Damaged_quantity;
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
    public int getDamaged_quantity() {
        return Damaged_quantity;
    }

    
}
