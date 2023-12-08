import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
//import java.io.IOException;
public class create_files {
    public create_files()
    {

    }
    public void create (String name)
    {
        try {
            File file = new File(name+".txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                }
            else {
                System.out.println("File already exists.");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Delete(String name )
    {
        File file = new File(name+".txt");
        if (file.delete()) {
            System.out.println("The deleted file is : " + file.getName());
        }
        else {
            System.out.println("Failed in deleting the file.");
        }
    }

    public void read (String name)
    {
        try {
            File file= new File(name+".txt");
            Scanner Reader = new Scanner(file);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println(data);
            }
            Reader.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  void write (String name, String Data)
    {
        try {
            FileWriter Writer = new FileWriter(name+".txt");
            Writer.write(Data);
            Writer.close();
            System.out.println("Successfully written.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}