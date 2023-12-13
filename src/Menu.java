import java.lang.invoke.SwitchPoint;
import java.util.*;
public class Menu {

    public static void user_interface()
    {

    }

    public static void  Admin_interface( int id ,String username,String password ,String type) {
        Scanner scanner;
        scanner = new Scanner(System.in);

        Admin admin = new Admin(id,username,password,type);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add employee");
            System.out.println("2. Delete employee");
            System.out.println("3. Update employee");
            System.out.println("4. List all employees");
            System.out.println("5. Search employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    admin.addEmployee();
                    break;
                case 2:
                    admin.deleteEmployee();
                    break;
                case 3:
                    admin.updateEmployee();
                    break;
                case 4:
                    admin.listEmployees();
                    break;
                case 5:
                    admin.searchEmployee();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    public static void Inventory_interface(String username, String password, String Type, int id)
    {
        Scanner scanner;
        scanner = new Scanner(System.in);

        Inventory_Employee I_E = new Inventory_Employee(username , password , Type , id);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add product");
            System.out.println("2. Delete product");
            System.out.println("3. Update product ");
            System.out.println("4. List all products ");
            System.out.println("5. Search for product");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String name ,section ,expiry;
                    int Id=1 ,quantity,Special_Range ,price;
                    System.out.println("Enter product name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter section name: ");
                    section = scanner.nextLine();
                    System.out.println("Enter product quantity: ");
                    quantity = scanner.nextInt();
                    System.out.println("Enter Special range : ");
                    Special_Range= scanner.nextInt();
                    System.out.println("Enter price : ");
                    price= scanner.nextInt();
                    System.out.println("Enter expiry date  in this format 'yyyy-MM-dd': ");
                    scanner.nextLine();
                    expiry = scanner.nextLine();
                    I_E.Add_product(name, Id , expiry , section ,  quantity,Special_Range , price);
                    break;
                case 2:
                    System.out.println("Enter product name: ");
                    name = scanner.nextLine();
                    I_E.Delete_product(name);
                    System.out.println("Product deleted successfully");
                    break;
                case 3:
                    System.out.println("Enter product name: ");
                    name= scanner.nextLine();
                    System.out.println("TO update ");
                    System.out.println("1.name");
                    System.out.println("2.ID");
                    System.out.println("3.section name ");
                    System.out.println("4.quantity");
                    System.out.println("4.price");
                    System.out.println("5.Date in this format 'yyyy-MM-dd': ");
                    System.out.println("6.Special range");
                    System.out.println("Enter your choice: ");
                    choice = scanner.nextInt();
                    System.out.println("Enter data :");
                    scanner.nextLine();
                    String new_data = scanner.nextLine();
                    //I_E.update_product(name, choice ,new_data);
                    System.out.println("thanks ");
                    break;
                case 4:
                    I_E.list_products();
                    break;
                case 5:
                    System.out.println("Enter product name: ");
                    name = scanner.next();
                    I_E.Search_products("names");
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
    public static void marketing_interface()
    {

    }

    public static void sales_interface()
    {

    }

    public static void main (String [] args)
    {
        Menu.Inventory_interface("Aya","1112","IE",11);
    }
}
