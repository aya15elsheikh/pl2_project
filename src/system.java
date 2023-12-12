import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.IOException;
public class system {

    public void Send_notification()
    {
        String data, q_in_file ,filename , expiry;
        int quantity;
        create_files c = new create_files();
        String path1 = "D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\names.txt";

        File file= new File(path1);
        try {
            Scanner Reader = new Scanner(file);
            while (Reader.hasNextLine()) {
                // quantity warning
                filename = Reader.nextLine();
          //      q_in_file = c.read_line("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\" + filename + ".txt", 4);
                quantity = 12;//Integer.parseInt(q_in_file);

                System.out.println(quantity);

                if (quantity < 15) {
                    data= "their  is lake of "+filename;
                    c.Append("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\notifications.txt", data);
                }
                // expiry warning
                expiry = c.read_line("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\products\\" + filename + ".txt",5);
                System.out.println(expiry);
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
                c.Append("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\notifications.txt", "Aya");
            }
        }catch (IOException ex )
        {
            System.out.println(ex.getMessage());
        }
    }
    public LocalDate String_date(String ex_date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate date = LocalDate.parse(ex_date, formatter);
            System.out.println(date);
            return date;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }


    public void Display_notifications ()
    {
        create_files c = new create_files();
        for (int  i=1; i<3 ; i++) {
            System.out.println(c.read_line("D:\\FCAI\\y2 sem 1\\pl2\\javacodes\\pl2 project\\notifications.txt", i));
        }
    }
}
