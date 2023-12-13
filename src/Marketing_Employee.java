import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
public class Marketing_Employee extends Employee {
    public Marketing_Employee(int ID, String Username, String password, String Type) {
        super(ID, Username, password, Type);
    }

    public void add_offer(String type, double time, double percentage) {
        Offers newOffer = new Offers(type, time, percentage);
        //System.out.println("Offer added Successfully !");
        try {
            create_files c = new create_files();
            String path = "C:\\Users\\MG\\IdeaProjects\\pl2_project\\Offers";
            c.Create(path, type);
            c.Append(path +type+".txt", String.valueOf(time));
            c.Append(path +type+".txt", String.valueOf(percentage));
            System.out.println("Offer added Successfully !");


        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void add_report(int number, String description, Products product_ifo) {
        Reports newReport = new Reports(number, description);
        try {
            create_files c = new create_files();
            String path = "C:\\Users\\MG\\IdeaProjects\\pl2_project\\Reports";
            c.Create(path, String.valueOf(number));
            c.Append(path +String.valueOf(number)+".txt", description);
            System.out.println("Report added Successfully !");


        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }



    }
}





