import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
public class Inventory_Employee extends Employee{

    public Inventory_Employee (String ID ,String Username, String password , String Type)
    {
        super( ID , Username, password , Type);
    }

    public boolean Add_product (String name  , int id , Date expiry ,String section , int quantity,int Special_Range )
    {  boolean flag = false;
        try {
            create_files c= new create_files();
            String path =  "D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\";
            c.Create(path,name);
            c.Append(path +name+".txt", name);
            c.Append(path +name+".txt", Integer.toString(id));
            c.Append(path +name+".txt", section);
            c.Append(path +name+".txt",Integer.toString(quantity));
            c.Append(path +name+".txt",Integer.toString(Special_Range));
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

    public  void update_product(String path_of_oldfile,String old_data ,String new_data )
    {
        String oldfile="path_of_oldfile";
        String temp="path_of_newfile";
        File newfile =new File(temp);
        try{
        FileWriter fw = new FileWriter(temp,false);
        BufferedWriter bw=new  BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        Scanner in=new Scanner(path_of_oldfile);
        while(in.hasNext())
        {
            String name=in.next();
            if(name.equals(old_data))
            {
                pw.println(new_data);
            }else
            {pw.println(name);
            }
            
        }
        in.close();
        pw.flush();
        pw.close();
       new File (oldfile).delete();
        File dump=new File(oldfile);
        newfile.renameTo(dump);
            System.out.println("update is succssful");
        } catch(Exception ex) {

            System.out.println("Error!");
        }
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

    public void manage_the_damage(Products p)
    {
       if(p!=null)
       {
           if(p.getDamaged_quantity()<=p.getQuantity())
           {
               p.setQuantity(p.getQuantity()-p.getDamaged_quantity());
               System.out.println("manage the damaged product is successfully");
           }
       }else{
           System.out.println("this product not exist");
       }
    }
    
    public void list_product(Products p)
    {
     System.out.println("ID:"+p.getId()+"\n"+"Name of product:"+p.getName()+"\n"+"Price of product:"+p.getPrice()+"\n"+
            "Quantiti of peoduct:"+p.getQuantity()+"\n"+"Expiry Date of product:"+p.getExpiry_Date()+"\n"+"Special range of product:"+
            p.getSpecial_Range()+"\n"+ "Damaged quantity of product:"+p.getDamaged_quantity());

    }
    

    // subtract product >>> seller
    // notification
}
