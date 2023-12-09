import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
public class Inventory_Employee extends Employee{

    public Inventory_Employee (int ID ,String Username, String password , String Type)
    {
        super( ID , Username, password , Type);
    }

    public boolean Add_product (String name  , int id , Date expiry ,String section , int quantity )
    {  boolean flag = false;
        try {
            create_files c= new create_files();
            String path =  "D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\";
            c.Create(path,name);
            c.Append(path +name+".txt", name);
            c.Append(path +name+".txt", Integer.toString(id));
            c.Append(path +name+".txt", section);
            c.Append(path +name+".txt",Integer.toString(quantity));
            SimpleDateFormat Formatter = new SimpleDateFormat("dd/MM/yyyy");
            String S_date= Formatter.format(expiry);
            c.Append(path +name+".txt",S_date);
            flag = true;
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return flag;
    }

    public boolean Delete_product (String name , String Section)
    {
        boolean flag =false ;
        try{
            String path =  "D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\"+name+".txt";
            create_files c= new create_files();
            c.Delete(path);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return flag;
    }

    public  boolean update_product(int id, String Section)
    {
        boolean update_flag =false;
       /*   implementation */
        return update_flag;
    }

    public void Search_products (String name)
    {
        File file = new File(name+".txt");
        if (file.exists()){
            try
            {
                create_files c= new create_files();
                String path =  "D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\"+name+".txt";
                System.out.println(Arrays.toString(c.Read(path)));
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        else {
            System.out.println("Product not found \n");
        }
    }

    public void manage_Damages(int id ,String name)
    {

    }

    public void Display_notifications ()
    {

    }

    // subtract product >>> seller
    // notification
}