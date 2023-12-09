import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class create_files {
    public create_files()
    {

    }
    public void Create (String path , String name)
    {
        try {
            File file = new File(path + name+".txt");
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

    public void Delete(String path )
    {
        File file = new File(path);
        if (file.delete()) {
            System.out.println("The deleted file is : " + file.getName());
        }
        else {
            System.out.println("Failed in deleting the file.");
        }
    }

    public String [] Read (String path)
    {
        String data []= new String[7];
        try {
            File file= new File(path);
            Scanner Reader = new Scanner(file);
            int i=0;
            while (Reader.hasNextLine()) {
                data [i]= Reader.nextLine();
                i++;
            }
            Reader.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public  void Append  (String path, String Data)
    {
        try {
            FileWriter Writer = new FileWriter(path, true );
            Writer.write(Data +"\n");
            Writer.close();
            System.out.println("Successfully written.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}