import java.util.Date;

public class Inventory_Employee extends Employee {
    private
      String Employee_name ;
    public boolean Add_product (String name,Date expiry ,String section)
         {   boolean adding_flag =false;
             /*   implementation */
             return adding_flag;
         }
    public boolean Delete_product (int id , String Section)
        {
            boolean del_flag =false;
            /*   implementation */
            return del_flag;
        }
    public  boolean update_product(int id, String Section)
        {
            boolean update_flag =false;
            /*   implementation */
            return update_flag;
        }
    public String Search_products ( int id , String name)
        {
            return "product name";
        }
    public void manage_Damages(int id ,String name)
        {

        }
}
