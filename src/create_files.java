import java.util.*;
import java.io.*;
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

    public void Delete(String path)
    {
        File file = new File(path);
        if (file.delete()) {
            System.out.println("The deleted file is : " + file.getName());
        }
        else {
            System.out.println("Failed in deleting the file.");
        }
    }

    public int countLines(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }
            return lineCount;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public String [] Read (String path)
    {
        int N = countLines(path);
        String data []= new String[N];
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
            System.out.println("Not found");
        }
        return data;
    }

    public String Read ( String path , int line )
    {
        String data ="";
        try {
            File file= new File(path);
            Scanner Reader = new Scanner(file);
            int i=0;
            while (Reader.hasNextLine() && i <= line) {
                data = Reader.nextLine();
                i++;
            }
            Reader.close();
        }
        catch (Exception e) {
            System.out.println("Not found");
        }
        return data;
    }

    public  void Append  (String path, String Data)
    {
        try {
            FileWriter Writer = new FileWriter(path,true );
            Writer.write(Data +"\n");
            Writer.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public  void clearFile(String path) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write("");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void print_file (String path)
    {
        try {
            File file= new File(path);
            Scanner Reader = new Scanner(file);
            while (Reader.hasNextLine()) {
                System.out.println(Reader.nextLine());
            }

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void update_file(String filePath, String oldString, String newString) {
        try {
            File fileToBeModified = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            String oldContent = "";
            while (line != null) {
                oldContent += line + System.lineSeparator();
                line = reader.readLine();
            }
            String newContent = oldContent.replaceAll(oldString, newString);
            FileWriter writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public  void searchFile(String filePath, String searchString) {
        try {
            File fileToBeSearched = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(fileToBeSearched));
            String line = reader.readLine();
            int lineNumber = 1;
            while (line != null) {
                if (line.contains(searchString)) {
                    System.out.println("Found at line " + lineNumber + ": " + line);
                }
                line = reader.readLine();
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


//    public boolean isDataExists(String filename, String targetData) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                if (line.equals(targetData)) {
//                    return true;
//                }
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }

}
