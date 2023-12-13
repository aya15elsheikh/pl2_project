import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
public class Inventory_Employee extends Employee{

   public Inventory_Employee(String username, String password, String Type, int id) {
        super(id, username, password, Type);
    }

   public boolean Add_product (String name  , int id ,String expiry ,String section , int quantity,int Special_Range ,int price )
    {  boolean flag = false;
        try {
            create_files c= new create_files();
            String path =  "D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\";
            c.Create(path,name);
            c.Append(path +name+".txt", name);
            c.Append(path +name+".txt", Integer.toString(id));
            c.Append(path +name+".txt", section);
            c.Append(path +name+".txt",Integer.toString(quantity));
            c.Append(path +name+".txt",Integer.toString(price));
            c.Append(path +name+".txt",Integer.toString(Special_Range));
//            SimpleDateFormat Formatter = new SimpleDateFormat("dd/MM/yyyy");
//            String S_date= Formatter.format(expiry);
            c.Append(path +name+".txt",expiry);
            c.Append(path +"names.txt",name);
            flag = true;
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return flag;
    }
   public boolean Delete_product (String name )
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

    public  void update_product(String path_of_oldfile ,String old_data ,String new_data)
    {
//       create_files c = new create_files();
//       String old_data = c.Read("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\"+name+".txt", line-1);
//       c.update_file("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\"+name+".txt", old_data , new_data);

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
    public void Search_products(String name )
    {
        File file = new File("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\"+name+".txt");
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
    
    public void list_products()
    {
        create_files c= new create_files();
        c.print_file("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\names.txt");
    }

    // subtract product >>> seller
    // notification
}
