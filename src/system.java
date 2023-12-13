import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
public class system {

    public void Send_notification()
    {
        String data="", q_in_file ,filename , expiry;
        int quantity;
        create_files c = new create_files();
        String path1 = "D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\names.txt";

        File file= new File(path1);
        try {
            Scanner Reader = new Scanner(file);
            while (Reader.hasNextLine()) {
                // quantity warning
                filename = Reader.nextLine();
                q_in_file = c.Read("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\" + filename + ".txt", 3);
                quantity = Integer.parseInt(q_in_file);

                if (quantity < 15) {
                    data= "their  is lake of "+filename;
                     c.Append("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\notifications.txt", data);
                }
                // expiry warning
                expiry = c.Read("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\" + filename + ".txt",5);
                LocalDate date = String_date(expiry);

                LocalDate today = LocalDate.now();
                int result = today.compareTo(date);

                if (result < 0 || result == 0){
                    data = filename + "expired ";
                    c.Append("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\notifications.txt", data);
                }
                else if ( today.isBefore(date) && today.plusDays(30).isAfter(date) )
                {
                    data= filename +" will expire soon ";
                    c.Append("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\notifications.txt", data);
                }
            }
        }catch (IOException ex )
        {
            System.out.println(ex.getMessage());
        }
    }
    public LocalDate String_date(String ex_date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(ex_date, formatter);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void Display_notifications ()
    {
        String  path = "D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\notifications.txt";
        create_files c = new create_files() ;
        c.print_file(path);
        c.clearFile(path);
    }
}
class Main_o {
public static void main(String[] args) {
        System.out.print("Hello ! \n");
        system s= new system();
        s.Send_notification();
        s.Display_notifications();
    }
}